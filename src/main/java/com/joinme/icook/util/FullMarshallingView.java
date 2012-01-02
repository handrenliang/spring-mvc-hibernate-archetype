package com.joinme.icook.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamResult;

import org.springframework.oxm.Marshaller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FullMarshallingView extends AbstractView {

    private Marshaller marshaller;
    public static final String DEFAULT_CONTENT_TYPE = "application/xml";

    public FullMarshallingView() {
        setContentType(DEFAULT_CONTENT_TYPE);
    }

    public FullMarshallingView(Marshaller marshaller) {
        setContentType(DEFAULT_CONTENT_TYPE);
        this.marshaller = marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    @Override
    protected void renderMergedOutputModel(Map model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Object> toBeMarshalled = locateToBeMarshalled(model);
        int size = toBeMarshalled.size();
        if (size == 0) {
            throw new ServletException(
                    "Unable to locate objects to be marshalled in model: "
                            + model);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);

        for (int i = 0; i < size; i++) {
            Object object = toBeMarshalled.get(i);
            ByteArrayOutputStream marshallerResult = new ByteArrayOutputStream();
            marshaller.marshal(object, new StreamResult(marshallerResult));
            String content = new String(marshallerResult.toByteArray(), "utf-8");
            content = content.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>","");
            if (i == 0) {
                content = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><result>".concat(content);
            }
            FileCopyUtils.copy(content.getBytes("utf-8"), bos);
        }
        FileCopyUtils.copy("</result>".getBytes("utf-8"), bos);

        response.setContentType(getContentType());
        response.setContentLength(bos.size());

        FileCopyUtils.copy(bos.toByteArray(), response.getOutputStream());
    }

    protected List<Object> locateToBeMarshalled(Map model)
            throws ServletException {
        List<Object> toBeMarshalled = new ArrayList<Object>();
        for (Object o : model.values()) {
            if (Collection.class.isAssignableFrom(o.getClass())) {
                for (Object t : (Collection) o) {
                    if (this.marshaller.supports(t.getClass())) {
                        toBeMarshalled.add(t);
                    }
                }
            } else if (this.marshaller.supports(o.getClass())) {
                toBeMarshalled.add(o);
            }
        }
        return toBeMarshalled;
    }
}

package com.joinme.icook.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleAndEncodingFilter implements Filter {
    private String encoding = "utf-8";
    private Locale locale = Locale.SIMPLIFIED_CHINESE;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        LocaleContextHolder.setLocale(locale);
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        String encoding = config.getInitParameter("encoding");
        if (encoding != null && encoding.length() > 0) {
            this.encoding = encoding;
        }
        
        String locale = config.getInitParameter("locale");
        if (locale != null && locale.length() > 0) {
            this.locale = new Locale(locale);
        }
    }

}

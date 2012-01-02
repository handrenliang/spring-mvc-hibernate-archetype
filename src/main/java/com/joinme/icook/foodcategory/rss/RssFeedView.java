package com.joinme.icook.foodcategory.rss;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.joinme.icook.foodcategory.model.FoodCategory;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Description;
import com.sun.syndication.feed.rss.Guid;
import com.sun.syndication.feed.rss.Item;

public class RssFeedView extends AbstractRssFeedView {

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
            HttpServletRequest request) {

        feed.setTitle("Sample Title");
        feed.setDescription("Sample Description");
        feed.setLink("http://google.com");

        super.buildFeedMetadata(model, feed, request);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Item> items = new ArrayList<Item>(1);
        List<FoodCategory> categories = (List<FoodCategory>) model
                .get("categories");
        for (FoodCategory category : categories) {
            Item item = new Item();
            item.setAuthor("lianghanzhen");
            item.setLink("http://www.joinme.com");
            Guid guid = new Guid();
            guid.setValue(category.getCategoryId()+"");
            item.setGuid(guid);
            Content content = new Content();
            content.setValue(category.getCategoryName());
            item.setContent(content);
            Description desc = new Description();
            desc.setValue(category.getCategoryDescription());
            item.setDescription(desc);
            items.add(item);
        }
        return items;
    }

}
package com.joinme.icook.foodcategory.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FoodCategory")
public class FoodCategory implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

    public Long getCategoryId() {
        return categoryId;
    }

    @XmlElement
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @XmlElement
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    @XmlElement
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

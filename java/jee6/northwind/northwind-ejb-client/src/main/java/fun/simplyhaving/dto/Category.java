package fun.simplyhaving.dto;

import java.io.InputStream;

public class Category {

    private Integer CategoryID;
    private String CategoryName;
    private String Description;
    private InputStream Picture;

    public Category() {
        
    }

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public InputStream getPicture() {
        return Picture;
    }

    public void setPicture(InputStream picture) {
        Picture = picture;
    }
    
}

package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subcategorydatum {

    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("homesolutions_image")
    @Expose
    private String homesolutionsImage;
    @SerializedName("sub_category_id")
    @Expose
    private Long subCategoryId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id id;

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getHomesolutionsImage() {
        return homesolutionsImage;
    }

    public void setHomesolutionsImage(String homesolutionsImage) {
        this.homesolutionsImage = homesolutionsImage;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

}

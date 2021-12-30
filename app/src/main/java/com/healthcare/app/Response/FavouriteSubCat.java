package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FavouriteSubCat {

    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("sub_category_id")
    @Expose
    private Long subCategoryId;
    @SerializedName("favourite_id")
    @Expose
    private Long favouriteId;
    @SerializedName("favourite_sub_cat")
    @Expose
    private String favouriteSubCat;
    @SerializedName("users_name")
    @Expose
    private String usersName;
    @SerializedName("users_email")
    @Expose
    private String usersEmail;
    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("homesolutions_image")
    @Expose
    private String homesolutionsImage;

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Long getFavouriteId() {
        return favouriteId;
    }

    public void setFavouriteId(Long favouriteId) {
        this.favouriteId = favouriteId;
    }

    public String getFavouriteSubCat() {
        return favouriteSubCat;
    }

    public void setFavouriteSubCat(String favouriteSubCat) {
        this.favouriteSubCat = favouriteSubCat;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

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


}

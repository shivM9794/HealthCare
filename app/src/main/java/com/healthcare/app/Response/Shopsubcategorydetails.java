package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shopsubcategorydetails {

    @SerializedName("shop_category_id")
    @Expose
    private Long shopCategoryId;
    @SerializedName("shop_sub_category_name")
    @Expose
    private String shopSubCategoryName;
    @SerializedName("shop_sub_category_slug")
    @Expose
    private String shopSubCategorySlug;
    @SerializedName("shop_price")
    @Expose
    private String shopPrice;
    @SerializedName("shop_text")
    @Expose
    private String shopText;
    @SerializedName("shop_description")
    @Expose
    private String shopDescription;
    @SerializedName("shop_cat_detail_image")
    @Expose
    private String shopCatDetailImage;
    @SerializedName("shop_cat_detail_img_alt")
    @Expose
    private String shopCatDetailImgAlt;
    @SerializedName("shop_sub_category_id")
    @Expose
    private Long shopSubCategoryId;
    @SerializedName("_id")
    @Expose
    private Id id;

    public Long getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Long shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public String getShopSubCategoryName() {
        return shopSubCategoryName;
    }

    public void setShopSubCategoryName(String shopSubCategoryName) {
        this.shopSubCategoryName = shopSubCategoryName;
    }

    public String getShopSubCategorySlug() {
        return shopSubCategorySlug;
    }

    public void setShopSubCategorySlug(String shopSubCategorySlug) {
        this.shopSubCategorySlug = shopSubCategorySlug;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopText() {
        return shopText;
    }

    public void setShopText(String shopText) {
        this.shopText = shopText;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getShopCatDetailImage() {
        return shopCatDetailImage;
    }

    public void setShopCatDetailImage(String shopCatDetailImage) {
        this.shopCatDetailImage = shopCatDetailImage;
    }

    public String getShopCatDetailImgAlt() {
        return shopCatDetailImgAlt;
    }

    public void setShopCatDetailImgAlt(String shopCatDetailImgAlt) {
        this.shopCatDetailImgAlt = shopCatDetailImgAlt;
    }

    public Long getShopSubCategoryId() {
        return shopSubCategoryId;
    }

    public void setShopSubCategoryId(Long shopSubCategoryId) {
        this.shopSubCategoryId = shopSubCategoryId;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

}

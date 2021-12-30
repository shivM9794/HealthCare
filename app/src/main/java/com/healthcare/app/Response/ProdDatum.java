package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProdDatum {

    @SerializedName("shop_sub_category_name")
    @Expose
    private String shopSubCategoryName;
    @SerializedName("shop_price")
    @Expose
    private String shopPrice;
    @SerializedName("shop_text")
    @Expose
    private String shopText;
    @SerializedName("shop_cat_image")
    @Expose
    private String shopCatImage;
    @SerializedName("shop_cat_image_alt")
    @Expose
    private String shopCatImageAlt;
    @SerializedName("shop_sub_category_id")
    @Expose
    private Long shopSubCategoryId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id__2 id;

    public String getShopSubCategoryName() {
        return shopSubCategoryName;
    }

    public void setShopSubCategoryName(String shopSubCategoryName) {
        this.shopSubCategoryName = shopSubCategoryName;
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

    public String getShopCatImage() {
        return shopCatImage;
    }

    public void setShopCatImage(String shopCatImage) {
        this.shopCatImage = shopCatImage;
    }

    public String getShopCatImageAlt() {
        return shopCatImageAlt;
    }

    public void setShopCatImageAlt(String shopCatImageAlt) {
        this.shopCatImageAlt = shopCatImageAlt;
    }

    public Long getShopSubCategoryId() {
        return shopSubCategoryId;
    }

    public void setShopSubCategoryId(Long shopSubCategoryId) {
        this.shopSubCategoryId = shopSubCategoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Id__2 getId() {
        return id;
    }

    public void setId(Id__2 id) {
        this.id = id;
    }


}

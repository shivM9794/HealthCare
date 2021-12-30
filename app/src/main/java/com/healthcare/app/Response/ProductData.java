package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductData {

    @SerializedName("shop_sub_category_name")
    @Expose
    private String shopSubCategoryName;
    @SerializedName("shop_price")
    @Expose
    private Integer shopPrice;
    @SerializedName("shop_text")
    @Expose
    private String shopText;
    @SerializedName("shop_cat_image")
    @Expose
    private String shopCatImage;
    @SerializedName("product_seq_id")
    @Expose
    private String productSeqId;
    @SerializedName("_id")
    @Expose
    private Id id;

    public String getShopSubCategoryName() {
        return shopSubCategoryName;
    }

    public void setShopSubCategoryName(String shopSubCategoryName) {
        this.shopSubCategoryName = shopSubCategoryName;
    }

    public Integer getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Integer shopPrice) {
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

    public String getProductSeqId() {
        return productSeqId;
    }

    public void setProductSeqId(String productSeqId) {
        this.productSeqId = productSeqId;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }


}

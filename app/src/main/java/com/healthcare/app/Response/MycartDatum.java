package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MycartDatum {

    @SerializedName("product_id")
    @Expose
    private Long productId;
    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("creation_lat")
    @Expose
    private String creationLat;
    @SerializedName("creation_long")
    @Expose
    private String creationLong;
    @SerializedName("cart_id")
    @Expose
    private Long cartId;
    @SerializedName("addedTo_cart")
    @Expose
    private String addedToCart;
    @SerializedName("product_seq_id")
    @Expose
    private String productSeqId;
    @SerializedName("shop_sub_category_name")
    @Expose
    private String shopSubCategoryName;
    @SerializedName("shop_text")
    @Expose
    private String shopText;
    @SerializedName("shop_price")
    @Expose
    private String shopPrice;
    @SerializedName("shop_cat_image")
    @Expose
    private String shopCatImage;
    @SerializedName("users_name")
    @Expose
    private Object usersName;
    @SerializedName("users_email")
    @Expose
    private Object usersEmail;
    @SerializedName("users_sequence_id")
    @Expose
    private String usersSequenceId;
    @SerializedName("users_mobile")
    @Expose
    private Long usersMobile;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationLat() {
        return creationLat;
    }

    public void setCreationLat(String creationLat) {
        this.creationLat = creationLat;
    }

    public String getCreationLong() {
        return creationLong;
    }

    public void setCreationLong(String creationLong) {
        this.creationLong = creationLong;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getAddedToCart() {
        return addedToCart;
    }

    public void setAddedToCart(String addedToCart) {
        this.addedToCart = addedToCart;
    }

    public String getProductSeqId() {
        return productSeqId;
    }

    public void setProductSeqId(String productSeqId) {
        this.productSeqId = productSeqId;
    }

    public String getShopSubCategoryName() {
        return shopSubCategoryName;
    }

    public void setShopSubCategoryName(String shopSubCategoryName) {
        this.shopSubCategoryName = shopSubCategoryName;
    }

    public String getShopText() {
        return shopText;
    }

    public void setShopText(String shopText) {
        this.shopText = shopText;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopCatImage() {
        return shopCatImage;
    }

    public void setShopCatImage(String shopCatImage) {
        this.shopCatImage = shopCatImage;
    }

    public Object getUsersName() {
        return usersName;
    }

    public void setUsersName(Object usersName) {
        this.usersName = usersName;
    }

    public Object getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(Object usersEmail) {
        this.usersEmail = usersEmail;
    }

    public String getUsersSequenceId() {
        return usersSequenceId;
    }

    public void setUsersSequenceId(String usersSequenceId) {
        this.usersSequenceId = usersSequenceId;
    }

    public Long getUsersMobile() {
        return usersMobile;
    }

    public void setUsersMobile(Long usersMobile) {
        this.usersMobile = usersMobile;
    }


}

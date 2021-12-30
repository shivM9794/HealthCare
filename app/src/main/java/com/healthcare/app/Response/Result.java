package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("usersData")
    @Expose
    private UsersData usersData;

    public UsersData getUsersData() {
        return usersData;
    }

    public void setUsersData(UsersData usersData) {
        this.usersData = usersData;
    }


    @SerializedName("categorydata")
    @Expose
    private List<Categorydatum> categorydata = null;
    @SerializedName("doctordata")
    @Expose
    private List<Doctordatum> doctordata = null;
    @SerializedName("prodData")
    @Expose
    private List<ProdDatum> prodData = null;
    @SerializedName("hospitalData")
    @Expose
    private List<HospitalDatum> hospitalData = null;
    @SerializedName("bannerData")
    @Expose
    private List<BannerDatum> bannerData = null;

    public List<Categorydatum> getCategorydata() {
        return categorydata;
    }

    public void setCategorydata(List<Categorydatum> categorydata) {
        this.categorydata = categorydata;
    }

    public List<Doctordatum> getDoctordata() {
        return doctordata;
    }

    public void setDoctordata(List<Doctordatum> doctordata) {
        this.doctordata = doctordata;
    }

    public List<ProdDatum> getProdData() {
        return prodData;
    }

    public void setProdData(List<ProdDatum> prodData) {
        this.prodData = prodData;
    }

    public List<HospitalDatum> getHospitalData() {
        return hospitalData;
    }

    public void setHospitalData(List<HospitalDatum> hospitalData) {
        this.hospitalData = hospitalData;
    }

    public List<BannerDatum> getBannerData() {
        return bannerData;
    }

    public void setBannerData(List<BannerDatum> bannerData) {
        this.bannerData = bannerData;
    }


    @SerializedName("subcategorydata")
    @Expose
    private List<Subcategorydatum> subcategorydata = null;

    public List<Subcategorydatum> getSubcategorydata() {
        return subcategorydata;
    }

    public void setSubcategorydata(List<Subcategorydatum> subcategorydata) {
        this.subcategorydata = subcategorydata;
    }


    @SerializedName("subcategorydetails")
    @Expose
    private Subcategorydetails subcategorydetails;

    public Subcategorydetails getSubcategorydetails() {
        return subcategorydetails;
    }

    public void setSubcategorydetails(Subcategorydetails subcategorydetails) {
        this.subcategorydetails = subcategorydetails;
    }

    @SerializedName("hospitalDatadetails")
    @Expose
    private HospitalDatadetails hospitalDatadetails;
    @SerializedName("similarhospitalData")
    @Expose
    private List<SimilarhospitalDatum> similarhospitalData = null;

    public HospitalDatadetails getHospitalDatadetails() {
        return hospitalDatadetails;
    }

    public void setHospitalDatadetails(HospitalDatadetails hospitalDatadetails) {
        this.hospitalDatadetails = hospitalDatadetails;
    }

    public List<SimilarhospitalDatum> getSimilarhospitalData() {
        return similarhospitalData;
    }

    public void setSimilarhospitalData(List<SimilarhospitalDatum> similarhospitalData) {
        this.similarhospitalData = similarhospitalData;
    }

    @SerializedName("doctorDatadetails")
    @Expose
    private DoctorDatadetails doctorDatadetails;
    @SerializedName("similarDoctorData")
    @Expose
    private List<SimilarDoctorDatum> similarDoctorData = null;

    public DoctorDatadetails getDoctorDatadetails() {
        return doctorDatadetails;
    }

    public void setDoctorDatadetails(DoctorDatadetails doctorDatadetails) {
        this.doctorDatadetails = doctorDatadetails;
    }

    public List<SimilarDoctorDatum> getSimilarDoctorData() {
        return similarDoctorData;
    }

    public void setSimilarDoctorData(List<SimilarDoctorDatum> similarDoctorData) {
        this.similarDoctorData = similarDoctorData;
    }


    @SerializedName("appointmentDetails")
    @Expose
    private AppointmentDetails appointmentDetails;

    public AppointmentDetails getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(AppointmentDetails appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    @SerializedName("ratingData")
    @Expose
    private RatingData ratingData;

    public RatingData getRatingData() {
        return ratingData;
    }

    public void setRatingData(RatingData ratingData) {
        this.ratingData = ratingData;
    }


    @SerializedName("shopcartData")
    @Expose
    private List<ShopcartDatum> shopcartData = null;
    @SerializedName("shopbannerData")
    @Expose
    private Boolean shopbannerData;

    public List<ShopcartDatum> getShopcartData() {
        return shopcartData;
    }

    public void setShopcartData(List<ShopcartDatum> shopcartData) {
        this.shopcartData = shopcartData;
    }

    public Boolean getShopbannerData() {
        return shopbannerData;
    }

    public void setShopbannerData(Boolean shopbannerData) {
        this.shopbannerData = shopbannerData;
    }

    @SerializedName("shopsubcategorydetails")
    @Expose
    private Shopsubcategorydetails shopsubcategorydetails;
    @SerializedName("similarProductData")
    @Expose
    private List<SimilarProductDatum> similarProductData = null;

    public Shopsubcategorydetails getShopsubcategorydetails() {
        return shopsubcategorydetails;
    }

    public void setShopsubcategorydetails(Shopsubcategorydetails shopsubcategorydetails) {
        this.shopsubcategorydetails = shopsubcategorydetails;
    }

    public List<SimilarProductDatum> getSimilarProductData() {
        return similarProductData;
    }

    public void setSimilarProductData(List<SimilarProductDatum> similarProductData) {
        this.similarProductData = similarProductData;
    }

    @SerializedName("orderplaceData")
    @Expose
    private OrderplaceData orderplaceData;

    public OrderplaceData getOrderplaceData() {
        return orderplaceData;
    }

    public void setOrderplaceData(OrderplaceData orderplaceData) {
        this.orderplaceData = orderplaceData;
    }

    @SerializedName("favouriteData")
    @Expose
    private FavouriteData favouriteData;

    public FavouriteData getFavouriteData() {
        return favouriteData;
    }

    public void setFavouriteData(FavouriteData favouriteData) {
        this.favouriteData = favouriteData;
    }

    @SerializedName("addtocartData")
    @Expose
    private AddtocartData addtocartData;

    public AddtocartData getAddtocartData() {
        return addtocartData;
    }

    public void setAddtocartData(AddtocartData addtocartData) {
        this.addtocartData = addtocartData;
    }

    @SerializedName("mycartData")
    @Expose
    private List<MycartDatum> mycartData = null;

    public List<MycartDatum> getMycartData() {
        return mycartData;
    }

    public void setMycartData(List<MycartDatum> mycartData) {
        this.mycartData = mycartData;
    }

    @SerializedName("productData")
    @Expose
    private ProductData productData;
    @SerializedName("userData")
    @Expose
    private UserData userData;
    @SerializedName("finalorderplaceData")
    @Expose
    private FinalorderplaceData finalorderplaceData;

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public FinalorderplaceData getFinalorderplaceData() {
        return finalorderplaceData;
    }

    public void setFinalorderplaceData(FinalorderplaceData finalorderplaceData) {
        this.finalorderplaceData = finalorderplaceData;
    }

    @SerializedName("total")
    @Expose
    private Float total;
    @SerializedName("GST")
    @Expose
    private Float gst;
    @SerializedName("finalTotal")
    @Expose
    private Float finalTotal;
    @SerializedName("cartData")
    @Expose
    private List<CartDatum> cartData = null;
    @SerializedName("cartuserData")
    @Expose
    private CartuserData cartuserData;
    @SerializedName("cartorderplaceData")
    @Expose
    private List<CartorderplaceDatum> cartorderplaceData = null;

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getGst() {
        return gst;
    }

    public void setGst(Float gst) {
        this.gst = gst;
    }

    public Float getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(Float finalTotal) {
        this.finalTotal = finalTotal;
    }

    public List<CartDatum> getCartData() {
        return cartData;
    }

    public void setCartData(List<CartDatum> cartData) {
        this.cartData = cartData;
    }

    public CartuserData getCartuserData() {
        return cartuserData;
    }

    public void setCartuserData(CartuserData cartuserData) {
        this.cartuserData = cartuserData;
    }

    public List<CartorderplaceDatum> getCartorderplaceData() {
        return cartorderplaceData;
    }

    public void setCartorderplaceData(List<CartorderplaceDatum> cartorderplaceData) {
        this.cartorderplaceData = cartorderplaceData;
    }

    @SerializedName("finalorderplaced")
    @Expose
    private List<Finalorderplaced> finalorderplaced = null;

    public List<Finalorderplaced> getFinalorderplaced() {
        return finalorderplaced;
    }

    public void setFinalorderplaced(List<Finalorderplaced> finalorderplaced) {
        this.finalorderplaced = finalorderplaced;
    }

    @SerializedName("myorderList")
    @Expose
    private List<Myorder> myorderList = null;

    public List<Myorder> getMyorderList() {
        return myorderList;
    }

    public void setMyorderList(List<Myorder> myorderList) {
        this.myorderList = myorderList;
    }

    @SerializedName("aboutBannerData")
    @Expose
    private AboutBannerData aboutBannerData;
    @SerializedName("aboutUsData")
    @Expose
    private AboutUsData aboutUsData;

    public AboutBannerData getAboutBannerData() {
        return aboutBannerData;
    }

    public void setAboutBannerData(AboutBannerData aboutBannerData) {
        this.aboutBannerData = aboutBannerData;
    }

    public AboutUsData getAboutUsData() {
        return aboutUsData;
    }

    public void setAboutUsData(AboutUsData aboutUsData) {
        this.aboutUsData = aboutUsData;
    }

    @SerializedName("disclaimerBannerData")
    @Expose
    private DisclaimerBannerData disclaimerBannerData;
    @SerializedName("disclaimerData")
    @Expose
    private DisclaimerData disclaimerData;

    public DisclaimerBannerData getDisclaimerBannerData() {
        return disclaimerBannerData;
    }

    public void setDisclaimerBannerData(DisclaimerBannerData disclaimerBannerData) {
        this.disclaimerBannerData = disclaimerBannerData;
    }

    public DisclaimerData getDisclaimerData() {
        return disclaimerData;
    }

    public void setDisclaimerData(DisclaimerData disclaimerData) {
        this.disclaimerData = disclaimerData;
    }

    @SerializedName("termsBannerData")
    @Expose
    private TermsBannerData termsBannerData;
    @SerializedName("termsConditionsData")
    @Expose
    private TermsConditionsData termsConditionsData;

    public TermsBannerData getTermsBannerData() {
        return termsBannerData;
    }

    public void setTermsBannerData(TermsBannerData termsBannerData) {
        this.termsBannerData = termsBannerData;
    }

    public TermsConditionsData getTermsConditionsData() {
        return termsConditionsData;
    }

    public void setTermsConditionsData(TermsConditionsData termsConditionsData) {
        this.termsConditionsData = termsConditionsData;
    }

    @SerializedName("partnerBannerData")
    @Expose
    private PartnerBannerData partnerBannerData;
    @SerializedName("partnersData")
    @Expose
    private PartnersData partnersData;

    public PartnerBannerData getPartnerBannerData() {
        return partnerBannerData;
    }

    public void setPartnerBannerData(PartnerBannerData partnerBannerData) {
        this.partnerBannerData = partnerBannerData;
    }

    public PartnersData getPartnersData() {
        return partnersData;
    }

    public void setPartnersData(PartnersData partnersData) {
        this.partnersData = partnersData;
    }

    @SerializedName("privacyBannerData")
    @Expose
    private PrivacyBannerData privacyBannerData;
    @SerializedName("privacyPolicyData")
    @Expose
    private PrivacyPolicyData privacyPolicyData;

    public PrivacyBannerData getPrivacyBannerData() {
        return privacyBannerData;
    }

    public void setPrivacyBannerData(PrivacyBannerData privacyBannerData) {
        this.privacyBannerData = privacyBannerData;
    }

    public PrivacyPolicyData getPrivacyPolicyData() {
        return privacyPolicyData;
    }

    public void setPrivacyPolicyData(PrivacyPolicyData privacyPolicyData) {
        this.privacyPolicyData = privacyPolicyData;
    }

    @SerializedName("favourite_sub_cat_list")
    @Expose
    private List<FavouriteSubCat> favouriteSubCatList = null;

    public List<FavouriteSubCat> getFavouriteSubCatList() {
        return favouriteSubCatList;
    }

    public void setFavouriteSubCatList(List<FavouriteSubCat> favouriteSubCatList) {
        this.favouriteSubCatList = favouriteSubCatList;
    }

    @SerializedName("prodListData")
    @Expose
    private List<ProdListDatum> prodListData = null;

    public List<ProdListDatum> getProdListData() {
        return prodListData;
    }

    public void setProdListData(List<ProdListDatum> prodListData) {
        this.prodListData = prodListData;
    }


}

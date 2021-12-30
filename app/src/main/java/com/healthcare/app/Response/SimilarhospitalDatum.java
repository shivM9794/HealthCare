package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarhospitalDatum {

    @SerializedName("hospital_name")
    @Expose
    private String hospitalName;
    @SerializedName("hospital_image")
    @Expose
    private String hospitalImage;
    @SerializedName("hospital_image_alt")
    @Expose
    private String hospitalImageAlt;
    @SerializedName("hospital_id")
    @Expose
    private Long hospitalId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("rating")
    @Expose
    private Float rating;
    @SerializedName("_id")
    @Expose
    private Id__1 id;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalImage() {
        return hospitalImage;
    }

    public void setHospitalImage(String hospitalImage) {
        this.hospitalImage = hospitalImage;
    }

    public String getHospitalImageAlt() {
        return hospitalImageAlt;
    }

    public void setHospitalImageAlt(String hospitalImageAlt) {
        this.hospitalImageAlt = hospitalImageAlt;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Id__1 getId() {
        return id;
    }

    public void setId(Id__1 id) {
        this.id = id;
    }

}

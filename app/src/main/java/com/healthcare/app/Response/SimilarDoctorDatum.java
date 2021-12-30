package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarDoctorDatum {

    @SerializedName("doctor_name")
    @Expose
    private String doctorName;
    @SerializedName("doctor_name_slug")
    @Expose
    private String doctorNameSlug;
    @SerializedName("specialist")
    @Expose
    private String specialist;
    @SerializedName("doc_fees")
    @Expose
    private Integer docFees;
    @SerializedName("doc_image")
    @Expose
    private String docImage;
    @SerializedName("doc_image_alt")
    @Expose
    private String docImageAlt;
    @SerializedName("doctor_id")
    @Expose
    private Long doctorId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id__1 id;
    @SerializedName("rating")
    @Expose
    private Float rating;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorNameSlug() {
        return doctorNameSlug;
    }

    public void setDoctorNameSlug(String doctorNameSlug) {
        this.doctorNameSlug = doctorNameSlug;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public Integer getDocFees() {
        return docFees;
    }

    public void setDocFees(Integer docFees) {
        this.docFees = docFees;
    }

    public String getDocImage() {
        return docImage;
    }

    public void setDocImage(String docImage) {
        this.docImage = docImage;
    }

    public String getDocImageAlt() {
        return docImageAlt;
    }

    public void setDocImageAlt(String docImageAlt) {
        this.docImageAlt = docImageAlt;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Id__1 getId() {
        return id;
    }

    public void setId(Id__1 id) {
        this.id = id;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

}

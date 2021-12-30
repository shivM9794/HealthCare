package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppointmentDetails {

    @SerializedName("appointment_id")
    @Expose
    private Long appointmentId;
    @SerializedName("sequence_appointment_id")
    @Expose
    private String sequenceAppointmentId;
    @SerializedName("doctor_id")
    @Expose
    private Long doctorId;
    @SerializedName("fees")
    @Expose
    private Integer fees;
    @SerializedName("appointment_date")
    @Expose
    private Integer appointmentDate;
    @SerializedName("appointment_time")
    @Expose
    private Integer appointmentTime;
    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("appointment_status")
    @Expose
    private String appointmentStatus;
    @SerializedName("status")
    @Expose
    private String status;
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

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getSequenceAppointmentId() {
        return sequenceAppointmentId;
    }

    public void setSequenceAppointmentId(String sequenceAppointmentId) {
        this.sequenceAppointmentId = sequenceAppointmentId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public Integer getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Integer appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Integer getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Integer appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}


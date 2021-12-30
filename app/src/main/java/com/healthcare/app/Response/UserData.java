package com.healthcare.app.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("users_sequence_id")
    @Expose
    private String usersSequenceId;
    @SerializedName("users_mobile")
    @Expose
    private Long usersMobile;
    @SerializedName("users_address")
    @Expose
    private String usersAddress;
    @SerializedName("users_email")
    @Expose
    private String usersEmail;
    @SerializedName("users_name")
    @Expose
    private String usersName;
    @SerializedName("_id")
    @Expose
    private Id__1 id;

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
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

    public String getUsersAddress() {
        return usersAddress;
    }

    public void setUsersAddress(String usersAddress) {
        this.usersAddress = usersAddress;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public Id__1 getId() {
        return id;
    }

    public void setId(Id__1 id) {
        this.id = id;
    }

}

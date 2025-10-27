package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser_details")
    private Long idUserDetails;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "contact_num")
    private Integer contactNum;
    @Column(name = "profile_pic_url")
    private String profilePicUrl;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email_id")
    private String emailId;
    @NotNull
    @Column(name = "is_valid", nullable = false)
    @ColumnDefault("1")
    private boolean isValid;

    public UserDetails() {
    }

    @Override
    public String toString() {
        return String.format(
                "UserDetails[id=%d, Name='%s', userType='%s']",
                idUserDetails, userName, userType);
    }

    public Long getIdUserDetails() {
        return idUserDetails;
    }

    public void setIdUserDetails(Long idUserDetails) {
        this.idUserDetails = idUserDetails;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getContactNum() {
        return contactNum;
    }

    public void setContactNum(Integer contactNum) {
        this.contactNum = contactNum;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

}

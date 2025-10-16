package com.texstre.celebclothing.entity;

import jakarta.persistence.*;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "iduser_details")
    private Long idUserDetails;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "contact_num")
    private Long contactNum;
    @Column(name = "profile_pic_url")
    private String profilePicUrl;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "is_valid")
    private boolean isValid;
    @Column(name = "botiqs_followed")
    private String botiqsFollowed;


    protected UserDetails() {}

    @Override
    public String toString() {
        return String.format(
                "UserDetails[id=%d, Name='%s', userType='%s']",
                idUserDetails, userName, userType);
    }
}

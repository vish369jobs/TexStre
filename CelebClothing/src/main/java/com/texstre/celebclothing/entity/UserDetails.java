package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}

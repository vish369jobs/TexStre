package com.texstre.celebclothing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="delivery_address")
public class DeliveryAddress {
    @Id
    private Long addressId;
    private Integer linkedUsrId;
    private String contactName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Integer pinCode;
    private String country;
}

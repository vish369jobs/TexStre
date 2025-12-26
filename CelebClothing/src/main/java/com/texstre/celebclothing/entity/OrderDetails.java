package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "ordered_by")
    private Long orderByUserId;
   /* @Column(name = "order_items_list")
    private List<ProductDetails> productList;*/
    @Column(name = "order_delivery_address_id")
    private Long deliveryAddressId;
    @Column(name = "order_total_cost")
    private Double totalCost;
    @CreationTimestamp
    @Column(name = "order_timestamp", nullable = false, updatable = false)
    private LocalDateTime orderDate;
}

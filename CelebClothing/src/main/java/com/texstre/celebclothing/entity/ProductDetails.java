package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "fabric")
    private String fabric;
    @Column(name = "base_price")
    private BigDecimal basePrice;
    @Column(name = "selling_price")
    private BigDecimal sellingPrice;
    @Column(name = "discount_percent")
    private Long discPercent;
    @Column(name = "discounted_price")
    private BigDecimal discountedPrice;
    @NotNull
    @Column(name = "apply_discount", nullable=false)
    @ColumnDefault("0")
    private boolean applyDisc;
    @NotNull
    @Column(name = "is_valid", nullable=false)
    @ColumnDefault("1")
    private boolean isValid;

}


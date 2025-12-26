package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

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
    @ElementCollection
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "id_product"))
    @Column(name = "available_sizes")
    private List<String> availableSizes;
    @ElementCollection
    @CollectionTable(name = "product_colors", joinColumns = @JoinColumn(name = "id_product"))
    @Column(name = "available_colors")
    private List<String> availableColors;
    @Column(name = "fabric")
    private String fabric;
    @Column(name = "prod_short_desc")
    private String prodShortDesc;
    @Column(name = "prod_long_desc")
    private String prodLongDesc;
    @Column(name = "base_price")
    private Float basePrice;
    @Column(name = "selling_price")
    private Float sellingPrice;
    @Column(name = "discount_percent")
    private Float discPercent;
    @Column(name = "discounted_price")
    private Float discountedPrice;
    @Column(name = "product_avg_rating")
    private Float prodAvgRating;
    @NotNull
    @Column(name = "apply_discount", nullable=false)
    @ColumnDefault("0")
    private boolean applyDisc;
    @NotNull
    @Column(name = "is_valid", nullable=false)
    @ColumnDefault("1")
    private boolean isValid;
}


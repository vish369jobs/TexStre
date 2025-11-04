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
@Table(name="boutique_products")
public class BoutiqueProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "botiq_product_id")
    private Long botiqProdId;
    @Column(name = "botiq_id")
    private String botiqId;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_category")
    private String productCategory;
    @NotNull
    @Column(name = "is_valid", nullable=false)
    @ColumnDefault("1")
    private boolean isValid;
}


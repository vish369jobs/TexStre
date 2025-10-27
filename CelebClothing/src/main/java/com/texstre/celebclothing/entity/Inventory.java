package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product_inventory")
public class Inventory {
    @Id
    @Column(name = "id_product")
    private Long productId;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "qty_unit")
    private String qtyUnit;
}

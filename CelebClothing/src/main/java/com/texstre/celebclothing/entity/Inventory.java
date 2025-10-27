package com.texstre.celebclothing.entity;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    @Column(name = "id_product")
    private Long productId;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "qty_unit")
    private String qtyUnit;
}

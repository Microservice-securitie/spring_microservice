package org.sid.orderservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.orderservice.model.Product;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProdectItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ProductId;
    @Transient
    private Product product;
    private double discount;
    private double price;
    private int quantity;
    @ManyToOne
    private Order order;
}

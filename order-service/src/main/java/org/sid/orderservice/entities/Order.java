package org.sid.orderservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.sid.orderservice.enums.OrderStatus;

import java.util.Date;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @OneToMany(mappedBy = "order")
    private List<ProdectItem> produItems;
}

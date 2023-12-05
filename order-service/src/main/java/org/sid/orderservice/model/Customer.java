package org.sid.orderservice.model;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String nom;
    private String email;
}

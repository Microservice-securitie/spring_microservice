package org.sid.orderservice.repository;

import org.sid.orderservice.entities.ProdectItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProdectItem, Long> {
}

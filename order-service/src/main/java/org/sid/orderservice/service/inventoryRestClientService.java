package org.sid.orderservice.service;

import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")   // j'appl CustomerRestClientService envoie une request vers cus..
public interface inventoryRestClientService {

    @GetMapping("/products/{id}?projection=fullProduct")
    public Product ProductById(@PathVariable Long id);

    @GetMapping("/products?projection=fullProduct")
    public PageModel<Product> AllProducts(@PathVariable Long id);
}
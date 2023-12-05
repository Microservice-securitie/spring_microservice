package org.sid.orderservice.service;

import org.sid.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")   // j'appl CustomerRestClientService envoie une request vers cus..
public interface CustomerRestClientService {

    @GetMapping("/customers/{id}?projection=fullCustomer")
    public Customer CustomerById(@PathVariable Long id);

    @GetMapping("/customers?projection=fullCustomer")
    public List<Customer> AllCustomers(@PathVariable Long id);
}

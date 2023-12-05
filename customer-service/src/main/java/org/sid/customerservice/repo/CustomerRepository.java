package org.sid.customerservice.repo;

import org.sid.customerservice.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}

package org.sid.orderservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.sid.orderservice.entities.Order;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repository.OrderRepository;
import org.sid.orderservice.repository.ProductItemRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @Autowired
    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get(); // Use orderRepository instance
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);

        order.getProduItems().forEach(pi -> {
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });

        return order;
    }
}

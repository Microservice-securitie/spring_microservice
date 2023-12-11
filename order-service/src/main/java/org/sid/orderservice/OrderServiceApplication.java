package org.sid.orderservice;

import org.sid.orderservice.entities.Order;
import org.sid.orderservice.entities.ProdectItem;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repository.OrderRepository;
import org.sid.orderservice.repository.ProductRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	CommandLineRunner start(OrderRepository orderRepository , CustomerRestClientService customerRestClientService,
							ProductRepository productRepository, InventoryRestClientService inventoryRestClientService){
		return args -> {

			List<Customer> customers = customerRestClientService.AllCustomers().getContent().stream().toList();

			List<Product> products = inventoryRestClientService.AllProducts().getContent().stream().toList();

			Long CustomersId = 1L;
			Random random = new Random();
			Customer customer=customerRestClientService.CustomerById(CustomersId);

			for (int i = 0; i < 20; i++) {
				Order order = Order.builder()

						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.status(Math.random()>0.5?OrderStatus.PENDING:OrderStatus.CREATED)
						.createdAt(new Date())
						.build();

				Order savedOrder = orderRepository.save(order);
				for (int j = 0; j < products.size(); j++) {
					if (Math.random()>0.70) {
						ProdectItem productItem = ProdectItem.builder()
								.order(savedOrder)
								.ProductId(products.get(j).getId()) // corrected to "productId"
								.price(products.get(j).getPrice())
								.quantity(1 + random.nextInt(10))
								.discount(Math.random())
								.build();
						productRepository.save(productItem);
					}
				}
			}
		};
	}
}

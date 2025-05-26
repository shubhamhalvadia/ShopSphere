package com.shopsphere.shopsphere;

import com.shopsphere.shopsphere.model.Product;
import com.shopsphere.shopsphere.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopSphereApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductRepository productRepo) {
		return args -> {
			if (productRepo.count() == 0) {
				productRepo.save(new Product(null, "Smartphone", "5G device", 699.99, 100));
				productRepo.save(new Product(null, "Laptop", "16GB RAM", 1099.00, 50));
			}
		};
	}
}

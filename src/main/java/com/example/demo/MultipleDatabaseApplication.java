package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.consumer.Consumer;
import com.example.demo.model.product.Product;
import com.example.demo.repo.ConsumerRepo;
import com.example.demo.repo.ProductRepository;

@SpringBootApplication
public class MultipleDatabaseApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository prepo;
	@Autowired
	private ConsumerRepo crepo;
	public static void main(String[] args) {
		SpringApplication.run(MultipleDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		prepo.saveAll(
				Arrays.asList(new Product(1,"goods","train"),
						new Product(2,"bad", "Plane"))
				);
		crepo.saveAll(
				Arrays.asList(new Consumer(1,"R@mail.com","rakesh"))
				);
		
		
	}

}

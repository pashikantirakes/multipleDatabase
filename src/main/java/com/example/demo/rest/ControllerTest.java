package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.consumer.Consumer;
import com.example.demo.model.product.Product;
import com.example.demo.repo.ConsumerRepo;
import com.example.demo.repo.ProductRepository;

@RestController
public class ControllerTest {
	@Autowired
	private ProductRepository prepo;
	@Autowired
	private ConsumerRepo crepo;
	
	@GetMapping("/product")
	public List<Product> getAll(){
		return prepo.findAll();
	}
	
	@GetMapping("/con")
	public List<Consumer> getAllConsumers(){
		return crepo.findAll();
	}
	

}

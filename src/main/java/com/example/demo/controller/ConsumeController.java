package com.example.demo.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Product;

@RestController
public class ConsumeController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/template/products")
	public String getProducts() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(header);
		
		return restTemplate.exchange("http://localhost:8085/products",HttpMethod.GET,entity,String.class).getBody();
	}
	
	@PostMapping("/template/products")
	public ResponseEntity<String> addProduct(@RequestBody Product prod) {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(prod, header);
		
		return restTemplate.exchange("http://localhost:8085/products",HttpMethod.POST,entity,String.class);
	}
}

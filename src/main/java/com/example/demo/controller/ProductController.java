package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;


@RestController
public class ProductController {
   private static Map<String, Product> productRepo = new HashMap<>();   
   static {      
      Product honey = new Product();
      honey.setId("1");
      honey.setName("Honey");
      productRepo.put(honey.getId(), honey);      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      productRepo.put(almond.getId(), almond);      
   }
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
	   System.out.println("getproducts called");
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
   
   @PostMapping(value = "/products")
   public ResponseEntity<Object> addProduct(@RequestBody Product prod) {
	   System.out.println("addproducts called");
	   productRepo.put(prod.getId(), prod);
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
   
}

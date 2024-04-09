package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.entity.Product;

import com.uw.cs506.team03.smartstock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    @Autowired
    public  ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/setProductCost")
    public String setProductCost(@RequestParam(name = "productId", required = true) Integer productId, @RequestParam(name = "targetCost", required = true) Integer targetCost) {
        return productService.setProductCost(productId, targetCost);
    }
    //=======================CRUD APIs==============================================

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }
    //find one tuple in the inventory table by id
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }
    //add one tuple in the inventory table
    @PostMapping("products")
    public Product addTuple(@RequestBody Product product) {
        product.setProductId(0);
        Product theTuple = productService.save(product);
        return  theTuple;
    }
    //update one tuple in the inventory table
    @PutMapping("products")
    public Product updateTuple(@RequestBody Product product) {
        Product theTuple = productService.save(product);
        return  theTuple;
    }
    //delete one tuple in the inventory table
    @DeleteMapping("products/{id}")
    public String deleteTuple(@PathVariable int id) {
        Product theTuple = productService.findById(id);
        if(theTuple == null) {
            throw new RuntimeException("can not find tuple id " + id);
        }
        productService.deleteById(id);
        return "deleted tuple[id: " + id + "success";
    }
}

package com.uw.cs506.team03.smartstock.controller;


import com.uw.cs506.team03.smartstock.entity.Product;

import com.uw.cs506.team03.smartstock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the controller for the product table
 */
@RestController
public class ProductController {

    ProductService productService;

    /**
     * This is the constructor for the ProductController class
     * @param productService the service for the product table
     */
    @Autowired
    public  ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * This method is used to get the product with the highest cost
     * @param productId the id of the product
     * @param targetCost the target cost
     * @return a string indicating the success of the operation
     */
    @PostMapping("/setProductCost")
    public String setProductCost(@RequestParam(name = "productId", required = true) Integer productId, @RequestParam(name = "targetCost", required = true) Integer targetCost) {
        return productService.setProductCost(productId, targetCost);
    }
    //=======================CRUD APIs==============================================

    /**
     * This method is used to get all the tuples in the product table
     * @return a list of all the tuples in the product table
     */
    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    /**
     * This method is used to get a specific tuple in the product table
     * @param id
     * @return the tuple with the specified id
     */
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }
    
    /**
     * This method is used to add a tuple to the product table
     * @param product
     * @return the tuple that was added
     */
    @PostMapping("products")
    public Product addTuple(@RequestBody Product product) {
        product.setProductId(0);
        Product theTuple = productService.save(product);
        return  theTuple;
    }
    
    /**
     * This method is used to update a tuple in the product table
     * @param product
     * @return the updated tuple
     */
    @PutMapping("products")
    public Product updateTuple(@RequestBody Product product) {
        Product theTuple = productService.save(product);
        return  theTuple;
    }
    
    /**
     * This method is used to delete a tuple in the product table
     * @param id
     * @return a string indicating whether the deletion was successful
     */
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

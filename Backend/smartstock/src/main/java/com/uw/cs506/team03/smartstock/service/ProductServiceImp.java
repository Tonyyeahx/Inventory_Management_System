package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Product;
import com.uw.cs506.team03.smartstock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is the service for the product table
 */
@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    /**
     * This method is used to set the target quantity of a product
     * @param productId the id of the product
     * @param targetQuantity the target quantity of the product
     * @return a message indicating the success of the operation
     */
    @Override
    public String setProductCost(Integer productId, Integer targetCost) {
        if(targetCost <= 0) return "\"msg\": \"Illegal targetQuantity input\"";
        Optional<Product> result = productRepository.findById(productId);
        Product tuple = null;
        if(result.isPresent()) {
            tuple = result.get();
        }
        else {
            throw new RuntimeException("can not find tuple by id: " + productId);
        }
        System.out.println(productId);
        System.out.println(targetCost);

        tuple.setCost(targetCost);
        productRepository.save(tuple);
        return "\"msg\": \"Target cost set successful\"";
    }

    /**
     * This method is used to find all the products
     * @return the list of products
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * This method is used to find a product by its id
     * @param id the id of the product
     * @return the product
     * @throws RuntimeException if the product is not found
     */
    @Override
    public Product findById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return product.get();
        }
        else {
            throw new RuntimeException("Do not find tuple id " + id);
        }
    }

    /**
     * This method is used to save a product
     * @param product the product to be saved
     * @return the saved product
     */
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    /**
     * This method is used to delete a product by its id
     * @param id the id of the product
     */
    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}

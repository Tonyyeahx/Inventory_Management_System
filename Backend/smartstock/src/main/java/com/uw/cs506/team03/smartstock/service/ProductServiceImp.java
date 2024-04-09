package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.entity.Product;
import com.uw.cs506.team03.smartstock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;


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


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

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

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}

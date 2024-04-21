package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.Product;
import com.uw.cs506.team03.smartstock.entity.Image;
import com.uw.cs506.team03.smartstock.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    // Mocking the ProductService
    @Mock
    private ProductService productService;

    // Injecting the mocked ProductService into the ProductController
    @InjectMocks
    private ProductController productController;

    // Setting up the mock
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // Testing the findAll method of the ProductController
    void findAll_shouldReturnListOfProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 10.0f, 1, 1, new Image()));
        products.add(new Product("Product 2", 20.0f, 2, 2, new Image()));

        when(productService.findAll()).thenReturn(products);

        List<Product> result = productController.findAll();

        assertEquals(products, result);
        verify(productService, times(1)).findAll();
    }

    @Test
    // Testing the findById method of the ProductController
    void findById_shouldReturnProductById() {
        int productId = 1;
        Product product = new Product("Product 1", 10.0f, 1, 1, new Image());
        product.setProductId(productId);

        when(productService.findById(productId)).thenReturn(product);

        Product result = productController.findById(productId);

        assertEquals(product, result);
        verify(productService, times(1)).findById(productId);
    }

    @Test
    // Testing the addTuple method of the ProductController
    void addTuple_shouldAddProductAndReturnAddedProduct() {
        Product product = new Product("New Product", 15.0f, 3, 2, new Image());
        Product addedProduct = new Product("New Product", 15.0f, 3, 2, new Image());
        addedProduct.setProductId(1);

        when(productService.save(product)).thenReturn(addedProduct);

        Product result = productController.addTuple(product);

        assertEquals(addedProduct, result);
        verify(productService, times(1)).save(product);
    }

    @Test
    // Testing the updateTuple method of the ProductController
    void updateTuple_shouldUpdateProductAndReturnUpdatedProduct() {
        Product product = new Product("Updated Product", 25.0f, 2, 1, new Image());
        product.setProductId(1);

        when(productService.save(product)).thenReturn(product);

        Product result = productController.updateTuple(product);

        assertEquals(product, result);
        verify(productService, times(1)).save(product);
    }

    @Test
    // Testing the deleteTuple method of the ProductController
    void deleteTuple_shouldDeleteProductAndReturnSuccessMessage() {
        int productId = 1;
        Product product = new Product("Product 1", 10.0f, 1, 1, new Image());
        product.setProductId(productId);

        when(productService.findById(productId)).thenReturn(product);

        String result = productController.deleteTuple(productId);

        assertEquals("deleted tuple[id: " + productId + "success", result);
        verify(productService, times(1)).findById(productId);
        verify(productService, times(1)).deleteById(productId);
    }
}
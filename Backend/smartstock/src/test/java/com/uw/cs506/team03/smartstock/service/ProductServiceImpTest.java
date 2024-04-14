package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Product;
import com.uw.cs506.team03.smartstock.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImpTest {

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private ProductRepository productRepository;

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private ProductServiceImp productService;

    // @BeforeEach annotation is used on a method containing the code to run before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // this test checks if the setProductCost method updates the cost of a product
    void setProductCost_ValidProductIdAndCost_UpdatesProductCost() {
        Integer productId = 1;
        Integer targetCost = 100;
        Product existingProduct = new Product();

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));

        String result = productService.setProductCost(productId, targetCost);

        assertEquals("\"msg\": \"Target cost set successful\"", result);
        verify(productRepository, times(1)).save(existingProduct);
    }

    @Test
    // this test checks if the setProductCost method returns an error message when the cost is invalid
    void setProductCost_InvalidCost_ReturnsErrorMessage() {
        Integer productId = 1;
        Integer targetCost = -100;

        String result = productService.setProductCost(productId, targetCost);

        assertEquals("\"msg\": \"Illegal targetQuantity input\"", result);
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    // this test checks if the findAll method returns a list of products
    void findAll_ReturnsListOfProducts() {
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product());
        expectedProducts.add(new Product());

        when(productRepository.findAll()).thenReturn(expectedProducts);

        List<Product> actualProducts = productService.findAll();

        assertEquals(expectedProducts, actualProducts);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    // this test checks if the findById method returns a product
    void findById_ExistingId_ReturnsProduct() {
        int productId = 1;
        Product expectedProduct = new Product();

        when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));

        Product actualProduct = productService.findById(productId);

        assertEquals(expectedProduct, actualProduct);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    // this test checks if the findById method throws an exception when the id does not exist
    void findById_NonExistingId_ThrowsException() {
        int productId = 1;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> productService.findById(productId));
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    // this test checks if the save method returns a saved product
    void save_Product_ReturnsSavedProduct() {
        Product productToSave = new Product();
        Product expectedSavedProduct = new Product();

        when(productRepository.save(productToSave)).thenReturn(expectedSavedProduct);

        Product actualSavedProduct = productService.save(productToSave);

        assertEquals(expectedSavedProduct, actualSavedProduct);
        verify(productRepository, times(1)).save(productToSave);
    }

    @Test
    // this test checks if the deleteById method deletes a product
    void deleteById_ExistingId_DeletesProduct() {
        int productId = 1;

        productService.deleteById(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }
}
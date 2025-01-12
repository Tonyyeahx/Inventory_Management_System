package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryServiceImpTest {

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private InventoryRepository inventoryRepository;

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private InventoryServiceImp inventoryService;

    // @BeforeEach annotation is used on a method containing the code to run before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // this test checks if the addProductToInventory method saves the product
    void addProductToInventory_ValidInput_SavesInventory() {
        int inventoryId = 1;
        int storeId = 1;
        int productId = 1;
        int quantity = 10;
        Date lastOrderDate = new Date();
        int orderQuantity = 5;
        float discount = 0.1f;
        float sellPrice = 9.99f;

        inventoryService.addProductToInventory(inventoryId, storeId, productId, quantity,
                lastOrderDate, orderQuantity, discount, sellPrice);

        verify(inventoryRepository, times(1)).save(any(Inventory.class));
    }

    @Test
    // this test checks if the deleteProductToAStoreFromInventory method deletes the product
    void deleteProductToAStoreFromInventory_ExistingProduct_DeletesInventory() {
        int inventoryId = 1;
        int storeId = 1;
        int productId = 1;
        Inventory existingInventory = new Inventory();

        when(inventoryRepository.findByStoreIdAndProductId(storeId, productId)).thenReturn(existingInventory);

        inventoryService.deleteProductToAStoreFromInventory(inventoryId, storeId, productId);

        verify(inventoryRepository, times(1)).delete(existingInventory);
    }

    @Test
    // this test checks if the findProductsByDynamicCriteria method returns a list of AllInOneDTO
    void findProductsByDynamicCriteria_ValidCriteria_ReturnsListOfAllInOneDTO() {
        Integer store = 1;
        String category = "Electronics";
        String supplier = "ABC Supplier";
        List<AllInOneDTO> expectedProducts = new ArrayList<>();

        when(inventoryRepository.findProductsByDynamicCriteria(store, category, supplier))
                .thenReturn(expectedProducts);

        List<AllInOneDTO> actualProducts = inventoryService.findProductsByDynamicCriteria(store, category, supplier);

        assertEquals(expectedProducts, actualProducts);
        verify(inventoryRepository, times(1)).findProductsByDynamicCriteria(store, category, supplier);
    }

    @Test
    // this test checks if the setInventoryQuantity method updates the quantity
    void setInventoryQuantity_ValidInventoryIdAndQuantity_UpdatesInventoryQuantity() {
        Integer inventoryId = 1;
        Integer targetQuantity = 20;
        Inventory existingInventory = new Inventory();

        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.of(existingInventory));

        String result = inventoryService.setInventoryQuantity(inventoryId, targetQuantity);

        assertEquals("\"msg\": \"Target quantity set successful\"", result);
        verify(inventoryRepository, times(1)).save(existingInventory);
    }

    @Test
    // this test checks if the setInventoryQuantity method returns an error message for invalid quantity
    void setInventoryQuantity_InvalidQuantity_ReturnsErrorMessage() {
        Integer inventoryId = 1;
        Integer targetQuantity = -10;

        String result = inventoryService.setInventoryQuantity(inventoryId, targetQuantity);

        assertEquals("\"msg\": \"Illegal targetQuantity input\"", result);
        verify(inventoryRepository, never()).save(any(Inventory.class));
    }

    @Test
    // this test checks if the findAll method returns a list of inventory
    void findAll_ReturnsListOfInventory() {
        List<Inventory> expectedInventory = new ArrayList<>();

        when(inventoryRepository.findAll()).thenReturn(expectedInventory);

        List<Inventory> actualInventory = inventoryService.findAll();

        assertEquals(expectedInventory, actualInventory);
        verify(inventoryRepository, times(1)).findAll();
    }

    @Test
    // this test checks if the findById method returns an inventory
    void findById_ExistingId_ReturnsInventory() {
        int inventoryId = 1;
        Inventory expectedInventory = new Inventory();

        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.of(expectedInventory));

        Inventory actualInventory = inventoryService.findById(inventoryId);

        assertEquals(expectedInventory, actualInventory);
        verify(inventoryRepository, times(1)).findById(inventoryId);
    }

    @Test
    // this test checks if the findById method throws an exception when the id does not exist
    void findById_NonExistingId_ThrowsException() {
        int inventoryId = 1;

        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> inventoryService.findById(inventoryId));
        verify(inventoryRepository, times(1)).findById(inventoryId);
    }

    @Test
    // this test checks if the save method returns a saved inventory
    void save_Inventory_ReturnsSavedInventory() {
        Inventory inventoryToSave = new Inventory();
        Inventory expectedSavedInventory = new Inventory();

        when(inventoryRepository.save(inventoryToSave)).thenReturn(expectedSavedInventory);

        Inventory actualSavedInventory = inventoryService.save(inventoryToSave);

        assertEquals(expectedSavedInventory, actualSavedInventory);
        verify(inventoryRepository, times(1)).save(inventoryToSave);
    }

    @Test
    // this test checks if the deleteById method deletes an inventory
    void deleteById_ExistingId_DeletesInventory() {
        int inventoryId = 1;

        inventoryService.deleteById(inventoryId);

        verify(inventoryRepository, times(1)).deleteById(inventoryId);
    }
}
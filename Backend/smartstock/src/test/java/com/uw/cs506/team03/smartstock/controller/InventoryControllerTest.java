package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.Inventory;
import com.uw.cs506.team03.smartstock.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InventoryControllerTest {

    // Mocking the InventoryService
    @Mock
    private InventoryService inventoryService;

    // Injecting the InventoryService into the InventoryController
    @InjectMocks
    private InventoryController inventoryController;

    // Setting up the mock
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // Testing the findAll method of the InventoryController
    void findAll_shouldReturnListOfInventories() {
        // Creating a list of Inventory objects
        List<Inventory> inventories = new ArrayList<>();
        inventories.add(new Inventory(1, 1, 1, 10, new Date(), 5, 0.1f, 9.99f));
        inventories.add(new Inventory(2, 1, 2, 20, new Date(), 10, 0.2f, 19.99f));

        // Mocking the findAll method of the InventoryService
        when(inventoryService.findAll()).thenReturn(inventories);

        List<Inventory> result = inventoryController.findAll();

        // Asserting that the result is equal to the inventories list
        assertEquals(inventories, result);
        verify(inventoryService, times(1)).findAll();
    }

    @Test
    // Testing the findById method of the InventoryController
    void findById_shouldReturnInventoryById() {
        int inventoryId = 1;
        Inventory inventory = new Inventory(inventoryId, 1, 1, 10, new Date(), 5, 0.1f, 9.99f);

        when(inventoryService.findById(inventoryId)).thenReturn(inventory);

        Inventory result = inventoryController.findById(inventoryId);

        assertEquals(inventory, result);
        verify(inventoryService, times(1)).findById(inventoryId);
    }

    @Test
    // Testing the addTuple method of the InventoryController
    void addTuple_shouldAddInventoryAndReturnAddedInventory() {
        Inventory inventory = new Inventory(0, 1, 1, 10, new Date(), 5, 0.1f, 9.99f);
        Inventory addedInventory = new Inventory(1, 1, 1, 10, new Date(), 5, 0.1f, 9.99f);

        when(inventoryService.save(inventory)).thenReturn(addedInventory);

        Inventory result = inventoryController.addTuple(inventory);

        assertEquals(addedInventory, result);
        verify(inventoryService, times(1)).save(inventory);
    }

    @Test
    // Testing the updateTuple method of the InventoryController
    void updateTuple_shouldUpdateInventoryAndReturnUpdatedInventory() {
        Inventory inventory = new Inventory(1, 1, 1, 15, new Date(), 8, 0.15f, 12.99f);

        when(inventoryService.save(inventory)).thenReturn(inventory);

        Inventory result = inventoryController.updateTuple(inventory);

        assertEquals(inventory, result);
        verify(inventoryService, times(1)).save(inventory);
    }

    @Test
    // Testing the deleteTuple method of the InventoryController
    void deleteTuple_shouldDeleteInventoryAndReturnSuccessMessage() {
        int inventoryId = 1;
        Inventory inventory = new Inventory(inventoryId, 1, 1, 10, new Date(), 5, 0.1f, 9.99f);

        when(inventoryService.findById(inventoryId)).thenReturn(inventory);

        String result = inventoryController.deleteTuple(inventoryId);

        assertEquals("deleted tuple[id: " + inventoryId + "success", result);
        verify(inventoryService, times(1)).findById(inventoryId);
        verify(inventoryService, times(1)).deleteById(inventoryId);
    }
}
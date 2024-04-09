package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.Store;
import com.uw.cs506.team03.smartstock.service.StoreService;
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

class StoreControllerTest {

    // Mocking the StoreService
    @Mock
    private StoreService storeService;

    // Injecting the mocked StoreService into the StoreController
    @InjectMocks
    private StoreController storeController;

    // Setting up the mock
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // Testing the findAll method of the StoreController
    void findAll_shouldReturnListOfStores() {
        List<Store> stores = new ArrayList<>();
        stores.add(new Store(40.7128f, -74.0060f, "Manager 1", new Date(), "123-456-7890"));
        stores.add(new Store(37.7749f, -122.4194f, "Manager 2", new Date(), "987-654-3210"));

        when(storeService.findAll()).thenReturn(stores);

        List<Store> result = storeController.findAll();

        assertEquals(stores, result);
        verify(storeService, times(1)).findAll();
    }

    @Test
    // Testing the findById method of the StoreController
    void findById_shouldReturnStoreById() {
        int storeId = 1;
        Store store = new Store(40.7128f, -74.0060f, "Manager 1", new Date(), "123-456-7890");
        store.setStoreId(storeId);

        when(storeService.findById(storeId)).thenReturn(store);

        Store result = storeController.findById(storeId);

        assertEquals(store, result);
        verify(storeService, times(1)).findById(storeId);
    }

    @Test
    // Testing the addTuple method of the StoreController
    void addTuple_shouldAddStoreAndReturnAddedStore() {
        Store store = new Store(40.7128f, -74.0060f, "Manager 1", new Date(), "123-456-7890");
        Store addedStore = new Store(40.7128f, -74.0060f, "Manager 1", new Date(), "123-456-7890");
        addedStore.setStoreId(1);

        when(storeService.save(store)).thenReturn(addedStore);

        Store result = storeController.addTuple(store);

        assertEquals(addedStore, result);
        verify(storeService, times(1)).save(store);
    }

    @Test
    // Testing the updateTuple method of the StoreController
    void updateTuple_shouldUpdateStoreAndReturnUpdatedStore() {
        Store store = new Store(40.7128f, -74.0060f, "Updated Manager", new Date(), "123-456-7890");
        store.setStoreId(1);

        when(storeService.save(store)).thenReturn(store);

        Store result = storeController.updateTuple(store);

        assertEquals(store, result);
        verify(storeService, times(1)).save(store);
    }

    @Test
    // Testing the deleteTuple method of the StoreController
    void deleteTuple_shouldDeleteStoreAndReturnSuccessMessage() {
        int storeId = 1;
        Store store = new Store(40.7128f, -74.0060f, "Manager 1", new Date(), "123-456-7890");
        store.setStoreId(storeId);

        when(storeService.findById(storeId)).thenReturn(store);

        String result = storeController.deleteTuple(storeId);

        assertEquals("deleted tuple[id: " + storeId + "success", result);
        verify(storeService, times(1)).findById(storeId);
        verify(storeService, times(1)).deleteById(storeId);
    }
}
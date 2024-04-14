package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Store;
import com.uw.cs506.team03.smartstock.repository.StoreRepository;
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

class StoreServiceImpTest {

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private StoreRepository storeRepository;

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private StoreServiceImp storeService;

    // @BeforeEach annotation is used on a method containing the code to run before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // this test checks if the findAll method returns a list of stores
    void findAll_ReturnsListOfStores() {
        List<Store> expectedStores = new ArrayList<>();
        expectedStores.add(new Store());
        expectedStores.add(new Store());

        when(storeRepository.findAll()).thenReturn(expectedStores);

        List<Store> actualStores = storeService.findAll();

        assertEquals(expectedStores, actualStores);
        verify(storeRepository, times(1)).findAll();
    }

    @Test
    // this test checks if the findById method returns a store
    void findById_ExistingId_ReturnsStore() {
        int storeId = 1;
        Store expectedStore = new Store();

        when(storeRepository.findById(storeId)).thenReturn(Optional.of(expectedStore));

        Store actualStore = storeService.findById(storeId);

        assertEquals(expectedStore, actualStore);
        verify(storeRepository, times(1)).findById(storeId);
    }

    @Test
    // this test checks if the findById method throws an exception when the id does not exist
    void findById_NonExistingId_ThrowsException() {
        int storeId = 1;

        when(storeRepository.findById(storeId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> storeService.findById(storeId));
        verify(storeRepository, times(1)).findById(storeId);
    }

    @Test
    // this test checks if the save method returns a saved store
    void save_Store_ReturnsSavedStore() {
        Store storeToSave = new Store();
        Store expectedSavedStore = new Store();

        when(storeRepository.save(storeToSave)).thenReturn(expectedSavedStore);

        Store actualSavedStore = storeService.save(storeToSave);

        assertEquals(expectedSavedStore, actualSavedStore);
        verify(storeRepository, times(1)).save(storeToSave);
    }

    @Test
    // this test checks if the deleteById method deletes a store
    void deleteById_ExistingId_DeletesStore() {
        int storeId = 1;

        storeService.deleteById(storeId);

        verify(storeRepository, times(1)).deleteById(storeId);
    }
}
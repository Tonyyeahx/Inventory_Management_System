package com.uw.cs506.team03.smartstock.service;

import com.uw.cs506.team03.smartstock.entity.Supplier;
import com.uw.cs506.team03.smartstock.repository.SupplierRepository;
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

class SupplierServiceImpTest {

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private SupplierRepository supplierRepository;

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private SupplierServiceImp supplierService;

    // @BeforeEach annotation is used on a method containing the code to run before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // this test checks if the findAll method returns a list of suppliers
    void findAll_ReturnsListOfSuppliers() {
        List<Supplier> expectedSuppliers = new ArrayList<>();
        expectedSuppliers.add(new Supplier());
        expectedSuppliers.add(new Supplier());

        when(supplierRepository.findAll()).thenReturn(expectedSuppliers);

        List<Supplier> actualSuppliers = supplierService.findAll();

        assertEquals(expectedSuppliers, actualSuppliers);
        verify(supplierRepository, times(1)).findAll();
    }

    @Test
    // this test checks if the findById method returns a supplier
    void findById_ExistingId_ReturnsSupplier() {
        int supplierId = 1;
        Supplier expectedSupplier = new Supplier();

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(expectedSupplier));

        Supplier actualSupplier = supplierService.findById(supplierId);

        assertEquals(expectedSupplier, actualSupplier);
        verify(supplierRepository, times(1)).findById(supplierId);
    }

    @Test
    // this test checks if the findById method throws an exception when the id does not exist
    void findById_NonExistingId_ThrowsException() {
        int supplierId = 1;

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> supplierService.findById(supplierId));
        verify(supplierRepository, times(1)).findById(supplierId);
    }

    @Test
    // this test checks if the save method returns a saved supplier
    void save_Supplier_ReturnsSavedSupplier() {
        Supplier supplierToSave = new Supplier();
        Supplier expectedSavedSupplier = new Supplier();

        when(supplierRepository.save(supplierToSave)).thenReturn(expectedSavedSupplier);

        Supplier actualSavedSupplier = supplierService.save(supplierToSave);

        assertEquals(expectedSavedSupplier, actualSavedSupplier);
        verify(supplierRepository, times(1)).save(supplierToSave);
    }

    @Test
    // this test checks if the deleteById method deletes a supplier
    void deleteById_ExistingId_DeletesSupplier() {
        int supplierId = 1;

        supplierService.deleteById(supplierId);

        verify(supplierRepository, times(1)).deleteById(supplierId);
    }
}
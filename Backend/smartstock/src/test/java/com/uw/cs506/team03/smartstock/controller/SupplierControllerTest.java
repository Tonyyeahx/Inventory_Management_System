package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.Supplier;
import com.uw.cs506.team03.smartstock.service.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SupplierControllerTest {

    // Mocking the SupplierService
    @Mock
    private SupplierService supplierService;

    // Injecting the mocked SupplierService into the SupplierController
    @InjectMocks
    private SupplierController supplierController;

    // Setting up the mock
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    // Testing the findAll method of the SupplierController
    void findAll_shouldReturnListOfSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(new Supplier("Supplier 1", "123-456-7890"));
        suppliers.add(new Supplier("Supplier 1", "123-456-7890"));

        when(supplierService.findAll()).thenReturn(suppliers);

        List<Supplier> result = supplierController.findAll();

        assertEquals(suppliers, result);
        verify(supplierService, times(1)).findAll();
    }

    @Test
    // Testing the findById method of the SupplierController
    void findById_shouldReturnSupplierById() {
        int supplierId = 1;
        Supplier supplier = new Supplier("Supplier 1", "123-456-7890");
        supplier.setSupplierId(supplierId);

        when(supplierService.findById(supplierId)).thenReturn(supplier);

        Supplier result = supplierController.findById(supplierId);

        assertEquals(supplier, result);
        verify(supplierService, times(1)).findById(supplierId);
    }

    @Test
    // Testing the addTuple method of the SupplierController
    void addTuple_shouldAddSupplierAndReturnAddedSupplier() {
        Supplier supplier = new Supplier("Supplier 1", "123-456-7890");
        Supplier addedSupplier = new Supplier("Supplier 1", "123-456-7890");
        addedSupplier.setSupplierId(1);

        when(supplierService.save(supplier)).thenReturn(addedSupplier);

        Supplier result = supplierController.addTuple(supplier);

        assertEquals(addedSupplier, result);
        verify(supplierService, times(1)).save(supplier);
    }

    @Test
    // Testing the updateTuple method of the SupplierController
    void updateTuple_shouldUpdateSupplierAndReturnUpdatedSupplier() {
        Supplier supplier = new Supplier("Supplier 1", "123-456-7890");
        supplier.setSupplierId(1);

        when(supplierService.save(supplier)).thenReturn(supplier);

        Supplier result = supplierController.updateTuple(supplier);

        assertEquals(supplier, result);
        verify(supplierService, times(1)).save(supplier);
    }

    @Test
    // Testing the deleteTuple method of the SupplierController
    void deleteTuple_shouldDeleteSupplierAndReturnSuccessMessage() {
        int supplierId = 1;
        Supplier supplier = new Supplier("Supplier 1", "123-456-7890");
        supplier.setSupplierId(supplierId);

        when(supplierService.findById(supplierId)).thenReturn(supplier);

        String result = supplierController.deleteTuple(supplierId);

        assertEquals("deleted tuple[id: " + supplierId + "success", result);
        verify(supplierService, times(1)).findById(supplierId);
        verify(supplierService, times(1)).deleteById(supplierId);
    }
}
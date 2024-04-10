package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.dto.AllInOneDTO;
import com.uw.cs506.team03.smartstock.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

@WebMvcTest(InventoryController.class)
public class InventoryControllerDTOTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryService inventoryService;

    private List<AllInOneDTO> sampleDTOList;

    @BeforeEach
    void setUp() {
        // Setting up sample DTOs
        AllInOneDTO dto = new AllInOneDTO(1, 2, 3, "Product Name", 4, "Category Name", 100.0f, 150.0f, 25, 10.0f, null, 50, 6, "Supplier Name");
        sampleDTOList = new ArrayList<>();
        sampleDTOList.add(dto);
    }

    @Test
    void findProductsByDynamicCriteria_ShouldReturnFilteredProducts() throws Exception {
        when(inventoryService.findProductsByDynamicCriteria(2, "Electronics", "Supplier XYZ")).thenReturn(sampleDTOList);

        mockMvc.perform(get("/filterInventories")
                .param("store", "2")
                .param("category", "Electronics")
                .param("supplier", "Supplier XYZ"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].inventoryId", is(1)))
                .andExpect(jsonPath("$[0].storeId", is(2)))
                .andExpect(jsonPath("$[0].productId", is(3)))
                .andExpect(jsonPath("$[0].productName", is("Product Name")))
                .andExpect(jsonPath("$[0].categoryId", is(4)))
                .andExpect(jsonPath("$[0].categoryName", is("Category Name")))
                .andExpect(jsonPath("$[0].cost", is(100.0)))
                .andExpect(jsonPath("$[0].sellPrice", is(150.0)))
                .andExpect(jsonPath("$[0].quantity", is(25)))
                .andExpect(jsonPath("$[0].discount", is(10.0)))
                .andExpect(jsonPath("$[0].orderQuantity", is(50)))
                .andExpect(jsonPath("$[0].supplierId", is(6)))
                .andExpect(jsonPath("$[0].supplierName", is("Supplier Name")));
    }
}
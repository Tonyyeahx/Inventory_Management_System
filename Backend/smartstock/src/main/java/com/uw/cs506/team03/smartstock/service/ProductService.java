package com.uw.cs506.team03.smartstock.service;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    float totalProductCost(int productId, int inventoryId, float cost);
}


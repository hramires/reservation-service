package com.reservation.controller.product.request;

import com.reservation.dto.ProductDto;

import java.util.List;

public class ProductRequest {

    private String document;
    public List<ProductDto> products;

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}

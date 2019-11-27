package com.reservation.controller.product.response;

import com.reservation.dto.ProductDto;

import java.util.List;

public class ProductResponse {

    private String document;
    private List<ProductDto> products;

    public ProductResponse(String document, List<ProductDto> products) {
        this.document = document;
        this.products = products;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

}

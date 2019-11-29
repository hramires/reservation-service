package com.reservation.service;

import com.reservation.domain.User;
import com.reservation.dto.ProductDto;
import com.reservation.controller.product.request.ProductRequest;
import com.reservation.controller.product.response.ProductResponse;
import com.reservation.converter.ProductConverter;
import com.reservation.domain.Product;
import com.reservation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    public ProductResponse addProduct(ProductRequest productRequest) {
        //User user = userService.findByDocument(productRequest.getDocument());
        List<Product> products = productConverter.convertToEntities(productRequest.getProducts(), null);
        List<Product> productsSaved = products.stream().map(product -> productRepository.save(product)).collect(Collectors.toList());
        List<ProductDto> productsToResponse = productConverter.convertToResponse(productsSaved);
        return new ProductResponse(productRequest.getDocument(), productsToResponse);
    }

}

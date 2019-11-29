package com.reservation.converter;

import com.reservation.domain.User;
import com.reservation.dto.ProductDto;
import com.reservation.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

    public List<Product> convertToEntities(List<ProductDto> productsDto, User user) {
        return productsDto.stream()
                .map(productDto -> productConverter(productDto, user))
                .collect(Collectors.toList());

    }

    public List<ProductDto> convertToResponse(List<Product> products) {
        return products.stream()
                .map(product -> productConverter(product))
                .collect(Collectors.toList());
    }

    private Product productConverter(ProductDto product, User user) {
        return new Product(product.getDescription(), product.getPrice(), user);
    }

    private ProductDto productConverter(Product product) {
        return new ProductDto(product.getDescription(), product.getPrice());
    }

}

package com.reservation.controller.product;

import com.reservation.service.ProductService;
import com.reservation.controller.product.request.ProductRequest;
import com.reservation.controller.product.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<ProductResponse> postProducts(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(productRequest));
    }

}

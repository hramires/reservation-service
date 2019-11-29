package com.reservation.controller.product;

import com.reservation.controller.product.request.ProductRequest;
import com.reservation.controller.product.response.ProductResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

public interface ProductController {

    @CrossOrigin
    @PostMapping("")
    @ApiOperation(value = "API used to insert a list of products that user consumes", response = ProductResponse.class)
    public ResponseEntity<ProductResponse> postProducts(ProductRequest productRequest);
}

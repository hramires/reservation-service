package com.reservation.controller.user;

import com.reservation.controller.product.response.ProductResponse;
import com.reservation.controller.user.response.CostumerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserController {

    @GetMapping("")
    @ApiOperation(value = "API used to get a list of costumers", response = CostumerResponse.class)
    public ResponseEntity<CostumerResponse> getCostumers();

    @GetMapping("/integrate")
    @ApiOperation(value = "API used to integrate with amazon s3 and read a file inside s3", response = Boolean.class)
    public ResponseEntity<Boolean> executeIntegration();

}

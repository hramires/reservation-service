package com.reservation.controller.user;

import com.reservation.controller.user.response.CostumerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("")
    @ApiOperation(value = "API used to get a list of costumers", response = CostumerResponse.class)
    public ResponseEntity<CostumerResponse> getCostumers();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/integrate")
    @ApiOperation(value = "API used to integrate with amazon s3 and read a file inside s3", response = Boolean.class)
    public ResponseEntity<Boolean> executeIntegration();

}

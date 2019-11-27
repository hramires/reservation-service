package com.reservation.controller.user;

import com.reservation.controller.user.response.CostumerResponse;
import com.reservation.dto.CostumerDto;
import com.reservation.service.AmazonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/costumers")
public class UserControllerImpl implements UserController {

    @Autowired
    private AmazonService amazonService;

    @Override
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<CostumerResponse> getCostumers() {
        return ResponseEntity.ok().body(new CostumerResponse(Arrays.asList(new CostumerDto("Jonathan", "0123456789", 2, "12/08/2019",
                "19/08/2019", 150.0))));
    }

    @Override
    public ResponseEntity<Boolean> executeIntegration() {
        try {
            amazonService.readAndWriteFile();
            return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
        }
    }


}

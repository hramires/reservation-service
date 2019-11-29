package com.reservation.controller.user;

import com.reservation.controller.user.response.CostumerResponse;
import com.reservation.dto.CostumerDto;
import com.reservation.dto.UserDto;
import com.reservation.service.AmazonService;
import com.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/costumers")
public class UserControllerImpl implements UserController {

    @Autowired
    private AmazonService amazonService;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<CostumerResponse> getCostumers() {
        return ResponseEntity.ok().body(new CostumerResponse(userService.findAll()));
    }

    @Override
    public ResponseEntity<Boolean> executeIntegration() {
        try {
            List<UserDto> users = amazonService.readAndWriteFile();
            userService.save(users);
            return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
        }
    }


}

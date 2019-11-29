package com.reservation.controller.reservation;

import com.reservation.controller.reservation.request.ReservationRequest;
import com.reservation.controller.reservation.response.ReservationResponse;
import com.reservation.controller.user.response.CostumerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ReservationController {

    @CrossOrigin
    @GetMapping("")
    @ApiOperation(value = "API used to get a list of reservations", response = ReservationResponse.class)
    public ResponseEntity<ReservationResponse> getReservations();

    @CrossOrigin
    @GetMapping("")
    @ApiOperation(value = "API used to book a new reservation", response = ReservationResponse.class)
    public ResponseEntity postReservations(@RequestBody ReservationRequest reservationRequest);

}

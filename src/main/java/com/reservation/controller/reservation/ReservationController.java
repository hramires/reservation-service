package com.reservation.controller.reservation;

import com.reservation.controller.reservation.request.ReservationCancelRequest;
import com.reservation.controller.reservation.request.ReservationCheckoutRequest;
import com.reservation.controller.reservation.request.ReservationRequest;
import com.reservation.controller.reservation.response.ReservationResponse;
import com.reservation.controller.user.response.CostumerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ReservationController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("")
    @ApiOperation(value = "API used to get a list of reservations", response = ReservationResponse.class)
    public ResponseEntity<ReservationResponse> getReservations();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("")
    @ApiOperation(value = "API used to book a new reservation", response = ReservationResponse.class)
    public ResponseEntity postReservations(@RequestBody ReservationRequest reservationRequest);

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/checkout")
    @ApiOperation(value = "API used to book a new reservation", response = ResponseEntity.class)
    public ResponseEntity checkout(@RequestBody ReservationCheckoutRequest reservationCheckoutRequest);

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cancel")
    @ApiOperation(value = "API used to book a new reservation", response = ResponseEntity.class)
    public ResponseEntity cancel(@RequestBody ReservationCancelRequest reservationCheckoutRequest);


}

package com.reservation.controller.reservation;

import com.reservation.controller.reservation.request.ReservationCancelRequest;
import com.reservation.controller.reservation.request.ReservationCheckoutRequest;
import com.reservation.controller.reservation.request.ReservationRequest;
import com.reservation.controller.reservation.response.ReservationResponse;
import com.reservation.dto.ReservationDto;
import com.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/reservations")
public class ReservationControllerImpl implements ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Override
    public ResponseEntity<ReservationResponse> getReservations() {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAll());
    }

    @Override
    public ResponseEntity<ReservationResponse> getReservationsByUser() {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getReservationsByUser());
    }

    @Override
    public ResponseEntity postReservations(ReservationRequest reservationRequest) {
        reservationService.save(reservationRequest);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity checkout(ReservationCheckoutRequest reservationCheckoutRequest) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity cancel(ReservationCancelRequest reservationCheckoutRequest) {
        return ResponseEntity.ok().build();
    }


}

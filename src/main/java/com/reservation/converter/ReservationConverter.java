package com.reservation.converter;

import com.reservation.controller.reservation.request.ReservationRequest;
import com.reservation.domain.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverter {
    public Reservation convert(ReservationRequest reservationRequest) {
        return new Reservation(null, null, reservationRequest.getRoomsQuantity(), reservationRequest.getCheckin(), reservationRequest.getCheckout());
    }
}

package com.reservation.converter;

import com.reservation.controller.reservation.request.ReservationRequest;
import com.reservation.controller.reservation.response.ReservationResponse;
import com.reservation.domain.Reservation;
import com.reservation.dto.ReservationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationConverter {
    public Reservation convert(ReservationRequest reservationRequest) {
        return new Reservation(null, null, reservationRequest.getRoomsQuantity(), reservationRequest.getCheckin(), reservationRequest.getCheckout());
    }

    public ReservationResponse convert(List<Reservation> reservations) {
        return new ReservationResponse(reservations.stream()
                .map(reservation -> convert(reservation))
                .collect(Collectors.toList()));
    }

    private ReservationDto convert(Reservation reservation) {
        return new ReservationDto(getUserName(reservation), reservation.getCheckin(), reservation.getCheckout(), reservation.getRoomsQuantity(), 150.0);
    }

    private String getUserName(Reservation reservation) {
        return reservation.getUser() != null ? reservation.getUser().getName() : "";
    }
}

package com.reservation.controller.reservation.response;

import com.reservation.dto.ReservationDto;

import java.util.List;

public class ReservationResponse {

    private List<ReservationDto> reservations;

    public ReservationResponse() {
    }

    public ReservationResponse(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

}

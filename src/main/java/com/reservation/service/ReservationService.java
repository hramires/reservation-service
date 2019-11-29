package com.reservation.service;

import com.reservation.controller.reservation.request.ReservationRequest;
import com.reservation.converter.ReservationConverter;
import com.reservation.domain.Reservation;
import com.reservation.domain.User;
import com.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationConverter reservationConverter;

    @Autowired
    private UserService userService;

    public void save(ReservationRequest reservationRequest) {
        //User user = userService.findByDocument(reservationRequest.getCpf());
        Reservation reservation = reservationConverter.convert(reservationRequest);
        //reservation.setUser(user);
        reservationRepository.save(reservation);
    }

}

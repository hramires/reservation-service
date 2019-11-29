package com.reservation.service;

import com.reservation.controller.reservation.request.ReservationRequest;
import com.reservation.controller.reservation.response.ReservationResponse;
import com.reservation.converter.ReservationConverter;
import com.reservation.domain.Product;
import com.reservation.domain.Reservation;
import com.reservation.domain.User;
import com.reservation.dto.ProductDto;
import com.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationConverter reservationConverter;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public void save(ReservationRequest reservationRequest) {
        User user = userService.findByName(reservationRequest.getName());
        Reservation reservation = reservationConverter.convert(reservationRequest);
        reservation.setUser(user);
        reservationRepository.save(reservation);
    }

    public ReservationResponse getAll() {
        return reservationConverter.convert(reservationRepository.findAll());
    }

    public ReservationResponse getReservationsByUser() {
        List<Reservation> reservations = reservationRepository.findByUserIsNotNull();
        ReservationResponse reservationResponse = reservationConverter.convert(reservations);
        reservationResponse = reservationConverter.adjustProductAndValue(reservationResponse);
        return reservationResponse;
    }
}

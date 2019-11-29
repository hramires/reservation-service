package com.reservation.converter;

import com.reservation.controller.reservation.request.ReservationRequest;
import com.reservation.controller.reservation.response.ReservationResponse;
import com.reservation.domain.Reservation;
import com.reservation.dto.ProductDto;
import com.reservation.dto.ReservationDto;
import com.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationConverter {

    @Autowired
    private ProductService productService;

    public Reservation convert(ReservationRequest reservationRequest) {
        return new Reservation(null, null, reservationRequest.getRoomsQuantity(), reservationRequest.getCheckin(), reservationRequest.getCheckout());
    }

    public ReservationResponse convert(List<Reservation> reservations) {
        return new ReservationResponse(reservations.stream()
                .map(reservation -> convert(reservation))
                .collect(Collectors.toList()));
    }

    private ReservationDto convert(Reservation reservation) {
        return new ReservationDto(getUserName(reservation), reservation.getCheckin(), reservation.getCheckout(), reservation.getRoomsQuantity(), 150.0,
                getUserCpf(reservation));
    }

    private String getUserName(Reservation reservation) {
        return reservation.getUser() != null ? reservation.getUser().getName() : "";
    }

    private String getUserCpf(Reservation reservation) {
        return reservation.getUser() != null ? reservation.getUser().getDocument() : "";
    }

    public ReservationResponse adjustProductAndValue(ReservationResponse reservationResponse) {
        reservationResponse.getReservations().stream().map(reservation -> getProductsByUser(reservation)).collect(Collectors.toList());
        return reservationResponse;
    }

    private ReservationDto getProductsByUser(ReservationDto reservationDto) {
        List<ProductDto> products = productService.findByUser(reservationDto);
        reservationDto.setPayment(reservationDto.getPayment() + productsValue(products));
        reservationDto.setProducts(products);
        return reservationDto;
    }

    private Double productsValue(List<ProductDto> products) {
        Double value = 0.0;
        for (ProductDto dto : products) {
            value = value + dto.getPrice();
        }
        return value;
    }
}

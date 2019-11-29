package com.reservation.repository;

import com.reservation.controller.reservation.response.ReservationResponse;
import com.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserIsNotNull();
}

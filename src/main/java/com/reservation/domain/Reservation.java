package com.reservation.domain;

import javax.persistence.*;

@Entity
@Table
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(columnDefinition = "user_id", referencedColumnName = "id")
    private User user;
    private Integer roomsQuantity;
    private String checkin;
    private String checkout;

    public Reservation() {
    }

    public Reservation(Long id, User user, Integer roomsQuantity, String checkin, String checkout) {
        this.id = id;
        this.user = user;
        this.roomsQuantity = roomsQuantity;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(Integer roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

}

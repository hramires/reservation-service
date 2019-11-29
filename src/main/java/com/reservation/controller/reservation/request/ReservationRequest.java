package com.reservation.controller.reservation.request;

public class ReservationRequest {

    private String name;
    private String cpf;
    private Integer roomsQuantity;
    private String checkin;
    private String checkout;

    public ReservationRequest() {
    }

    public ReservationRequest(String name, String cpf, Integer roomsQuantity, String checkin, String checkout) {
        this.name = name;
        this.cpf = cpf;
        this.roomsQuantity = roomsQuantity;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

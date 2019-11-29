package com.reservation.dto;

import java.util.List;

public class ReservationDto {

    private String name;
    private String checkin;
    private String checkout;
    private Integer roomsQuantity;
    private Double payment;
    private String cpf;
    private List<ProductDto> products;

    public ReservationDto() {
    }

    public ReservationDto(String name, String checkin, String checkout, Integer roomsQuantity, Double payment, String cpf) {
        this.name = name;
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomsQuantity = roomsQuantity;
        this.payment = payment;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(Integer roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}

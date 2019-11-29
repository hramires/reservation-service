package com.reservation.dto;

public class CostumerDto {

    private String name;
    private String cpf;
    private Integer roomsQuantity;
    private String checkin;
    private String checkout;
    private Double payment;

    public CostumerDto() {
    }

    public CostumerDto(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public CostumerDto(String name, String cpf, Integer roomsQuantity, String checkin, String checkout, Double payment) {
        this.name = name;
        this.cpf = cpf;
        this.roomsQuantity = roomsQuantity;
        this.checkin = checkin;
        this.checkout = checkout;
        this.payment = payment;
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

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

}

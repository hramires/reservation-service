package com.reservation.controller.reservation.request;

public class ReservationCancelRequest {

    private String cpf;
    private String checkin;
    private String checkout;

    public ReservationCancelRequest() {
    }

    public ReservationCancelRequest(String cpf, String checkin, String checkout) {
        this.cpf = cpf;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

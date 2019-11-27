package com.reservation.controller.user.response;

import com.reservation.dto.CostumerDto;

import java.util.List;

public class CostumerResponse {

    private List<CostumerDto> costumers;

    public CostumerResponse() {
    }

    public CostumerResponse(List<CostumerDto> costumers) {
        this.costumers = costumers;
    }

    public List<CostumerDto> getCostumers() {
        return costumers;
    }

    public void setCostumers(List<CostumerDto> costumers) {
        this.costumers = costumers;
    }
}

package com.my.company.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentStatusResponse {

    @JsonProperty("status")
    private String status;

    // Constructeurs
    public PaymentStatusResponse() {}

    public PaymentStatusResponse(String status) {
        this.status = status;
    }

    // Getter / Setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

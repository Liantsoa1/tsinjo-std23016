package com.my.company.model;

public class PaymentDto {
    private String id;
    private String verificationStatus;
    private String payerEmail;
    private int amount;
    private String pspType;
    private String creationInstant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPspType() {
        return pspType;
    }

    public void setPspType(String pspType) {
        this.pspType = pspType;
    }

    public String getCreationInstant() {
        return creationInstant;
    }

    public void setCreationInstant(String creationInstant) {
        this.creationInstant = creationInstant;
    }
}

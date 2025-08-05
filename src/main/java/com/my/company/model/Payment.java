package com.my.company.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private String payementId;
    private LocalDate paymentDate;
    private int paymentAmount;
    private MeansOfPayment meansOfPayment;
}

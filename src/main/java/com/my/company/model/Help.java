
package com.my.company.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Help {
    private Long helpId;
    private Beneficiary beneficiary;
    private Payment payment;
    private String description;
}
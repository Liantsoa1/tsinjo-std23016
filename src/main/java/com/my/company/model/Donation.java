

package com.my.company.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Donation {
    private Long donationId;
    private Donor donor;
    private Payment payment;
}
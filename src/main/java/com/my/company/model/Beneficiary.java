package com.my.company.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "beneficiary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficiary_id")
    private Long beneficiaryId;

    @Column(name = "full_name", nullable = false)
    private String fullName;
}

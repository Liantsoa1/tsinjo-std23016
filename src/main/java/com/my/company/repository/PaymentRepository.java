package com.my.company.repository;

import com.my.company.model.Payment;
import com.my.company.model.VerificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findByVerificationStatus(VerificationStatus status);
}

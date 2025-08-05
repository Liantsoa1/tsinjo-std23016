package com.my.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.my.company.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
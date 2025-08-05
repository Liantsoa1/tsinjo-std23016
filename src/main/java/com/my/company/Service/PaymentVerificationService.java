package com.my.company.Service;

import com.my.company.model.Payment;
import com.my.company.model.VerificationStatus;
import com.my.company.repository.PaymentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentVerificationService {

    private final PaymentRepository paymentRepository;
    private final VolaClient volaClient;

    public PaymentVerificationService(PaymentRepository paymentRepository, VolaClient volaClient) {
        this.paymentRepository = paymentRepository;
        this.volaClient = volaClient;
    }

    @Scheduled(fixedDelay = 60000)  // toutes les 60 secondes
    public void verifyPendingPayments() {
        List<Payment> pendingPayments = paymentRepository.findByVerificationStatus(VerificationStatus.VERIFYING);

        for (Payment payment : pendingPayments) {
            VerificationStatus newStatus = volaClient.checkPaymentStatus(payment.getPaymentId());

            if (newStatus != VerificationStatus.VERIFYING) {
                payment.setVerificationStatus(newStatus);
                paymentRepository.save(payment);
            }
        }
    }
}

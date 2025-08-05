package com.my.company.Controller;

import com.my.company.model.*;
import com.my.company.repository.HelpRepository;
import com.my.company.repository.DonationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TsinjoController {

    @Autowired
    private HelpRepository helpRepository;

    @Autowired
    private DonationRepository donationRepository;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Help> helps = helpRepository.findAll();
        List<Donation> donations = donationRepository.findAll();

        model.addAttribute("helps", helps);
        model.addAttribute("donations", donations);

        return "home";
    }

    @PostMapping("/donations")
    public String submitDonation(@RequestParam String email,
                                 @RequestParam MeansOfPayment moyenPaiement,
                                 @RequestParam String paymentReference) {

        // 1. Créer un Payment local, avec verificationStatus = VERIFYING
        Payment payment = new Payment();
        payment.setPaymentId(paymentReference);
        payment.setPayerEmail(email);
        payment.setPaymentDate(LocalDate.now());
        payment.setMeansOfPayment(moyenPaiement);
        payment.setVerificationStatus(VerificationStatus.VERIFYING);
        payment.setPaymentAmount();

        paymentRepository.save(payment);

        // 2. Créer la Donation liée à ce paiement
        Donor donor = donorRepository.findByEmail(email)
                .orElseGet(() -> createNewDonor(email));
        Donation donation = new Donation();
        donation.setDonor(donor);
        donation.setPayment(payment);

        donationRepository.save(donation);

        // 3. (Optionnel) Appeler l'API Vola pour soumettre le paiement
        volaClient.submitPayment(payment);

        // 4. Retourner vers la page d'accueil
        return "redirect:/";
    }

}

package com.my.company.Service;

import com.my.company.model.VerificationStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class VolaClient {

    private final WebClient webClient;

    public VolaClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://42cwka3n4ifcp7ufheyrpmph240iuaxo.lambda-url.eu-west-3.on.aws/v3") // URL de l'API Vola
                .build();
    }

    public VerificationStatus checkPaymentStatus(String paymentId) {
        try {
            PaymentStatusResponse response = webClient.get()
                    .uri("/payments/{id}", paymentId)
                    .retrieve()
                    .bodyToMono(PaymentStatusResponse.class)
                    .block();

            if (response == null || response.getStatus() == null) {
                return VerificationStatus.VERIFYING; // défaut
            }

            // Mapper la réponse Vola en VerificationStatus de l’app
            switch (response.getStatus()) {
                case "SUCCEEDED":
                    return VerificationStatus.SUCCEEDED;
                case "FAILED":
                    return VerificationStatus.FAILED;
                default:
                    return VerificationStatus.VERIFYING;
            }

        } catch (Exception e) {
            // En cas d'erreur, on considère qu'on n'a pas encore de confirmation
            return VerificationStatus.VERIFYING;
        }
    }

    // Tu peux ajouter une méthode submitPayment() pour envoyer le paiement initialement
}

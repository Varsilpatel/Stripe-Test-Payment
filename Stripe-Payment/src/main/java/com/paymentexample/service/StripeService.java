package com.paymentexample.service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    public PaymentIntent createPaymentIntent(long amount, String currency) throws Exception {
        Stripe.apiKey = stripeApiKey;

        com.stripe.param.PaymentIntentCreateParams params =
                com.stripe.param.PaymentIntentCreateParams.builder()
                        .setAmount(amount * 100) // Amount in cents
                        .setCurrency(currency)
                        .build();

        return PaymentIntent.create(params);
    }
}

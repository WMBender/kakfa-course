package com.weslei.bender.payment_service.service;

import com.weslei.bender.payment_service.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}

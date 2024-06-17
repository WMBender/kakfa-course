package com.weslei.bender.payment_service.service.impl;

import com.weslei.bender.payment_service.model.Payment;
import com.weslei.bender.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void sendPayment(Payment payment) {
        log.info("PaymentServiceImpl ::: Payment received {}", payment);
    }
}

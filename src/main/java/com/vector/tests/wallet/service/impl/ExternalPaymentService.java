package com.vector.tests.wallet.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.vector.tests.wallet.service.PaymentService;
import com.vector.tests.wallet.service.PaymentServiceException;

@Service
public class ExternalPaymentService implements PaymentService {
    private BigDecimal threshold = new BigDecimal(10);
    
    @Override
    public void charge(
        BigDecimal amount) throws PaymentServiceException{
        if (amount.compareTo(threshold) < 0) {
            throw new PaymentServiceException();
        }
    }
}

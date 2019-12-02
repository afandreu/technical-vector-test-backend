package com.vector.tests.wallet.service.impl;

import java.math.BigDecimal;

import org.junit.Test;

import com.vector.tests.wallet.service.PaymentServiceException;

public class ExternalPaymentServiceTest {
    
    ExternalPaymentService s = new ExternalPaymentService();
    
    @Test(expected = PaymentServiceException.class)
    public void test_nok() throws PaymentServiceException{
        s.charge(new BigDecimal(5));
    }
    
    @Test
    public void test_ok() throws PaymentServiceException{
        s.charge(new BigDecimal(15));
    }
}

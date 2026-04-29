package com.springboot.hrpayroll.services;

import com.springboot.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        return new Payment("Pedro", 200.0, days);
    }
}

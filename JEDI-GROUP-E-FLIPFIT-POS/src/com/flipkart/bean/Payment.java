package com.flipkart.bean;

import com.flipkart.utils.PaymentType;

public class Payment {
    private Long paymentId;
    private PaymentType paymentType;
    private Long payerId;

    public Long getPaymentId() {
        return paymentId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Long getPayerId() {
        return payerId;
    }
}

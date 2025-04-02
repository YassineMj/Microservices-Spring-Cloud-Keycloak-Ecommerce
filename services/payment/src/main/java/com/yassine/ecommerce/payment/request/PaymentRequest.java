package com.yassine.ecommerce.payment.request;

import com.yassine.ecommerce.payment.model.Customer;
import com.yassine.ecommerce.payment.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    Integer id,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    Customer customer
) {
}

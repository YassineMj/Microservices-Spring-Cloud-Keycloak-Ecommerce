package com.yassine.ecommerce.payment.mapper;

import com.yassine.ecommerce.payment.request.PaymentRequest;
import com.yassine.ecommerce.payment.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

  public Payment toPayment(PaymentRequest request) {
    if (request == null) {
      return null;
    }
    return Payment.builder()
        .id(request.id())
        .paymentMethod(request.paymentMethod())
        .amount(request.amount())
        .orderId(request.orderId())
        .build();
  }
}

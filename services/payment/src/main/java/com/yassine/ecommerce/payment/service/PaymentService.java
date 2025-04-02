package com.yassine.ecommerce.payment.service;

import com.yassine.ecommerce.notification.NotificationProducer;
import com.yassine.ecommerce.notification.PaymentNotificationRequest;
import com.yassine.ecommerce.payment.mapper.PaymentMapper;
import com.yassine.ecommerce.payment.repository.PaymentRepository;
import com.yassine.ecommerce.payment.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

  private final PaymentRepository repository;
  private final PaymentMapper mapper;
  private final NotificationProducer notificationProducer;

  public Integer createPayment(PaymentRequest request) {
    var payment = this.repository.save(this.mapper.toPayment(request));

    this.notificationProducer.sendNotification(
            new PaymentNotificationRequest(
                    request.orderReference(),
                    request.amount(),
                    request.paymentMethod(),
                    request.customer().firstname(),
                    request.customer().lastname(),
                    request.customer().email()
            )
    );
    return payment.getId();
  }
}

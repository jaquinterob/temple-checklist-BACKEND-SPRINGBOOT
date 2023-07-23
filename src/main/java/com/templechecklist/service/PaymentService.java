package com.templechecklist.service;

import com.templechecklist.persistence.entity.PaymentEntity;
import com.templechecklist.persistence.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    IPaymentRepository paymentRepository;

    public List<PaymentEntity> getAll() {
        return paymentRepository.findAll();
    }

    public PaymentEntity save(PaymentEntity paymentEntity) {
        return paymentRepository.save(paymentEntity);
    }

    public Boolean delete(String uuid) {
        try {
            paymentRepository.deleteById(uuid);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}

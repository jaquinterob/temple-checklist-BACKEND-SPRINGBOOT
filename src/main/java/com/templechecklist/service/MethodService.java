package com.templechecklist.service;

import com.templechecklist.persistence.entity.MethodEntity;
import com.templechecklist.persistence.entity.PaymentEntity;
import com.templechecklist.persistence.repository.IMethodRepository;
import com.templechecklist.persistence.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodService {
    @Autowired
    IMethodRepository methodRepository;

    public List<MethodEntity> getAll() {
        return methodRepository.findAll();
    }

    public MethodEntity save(MethodEntity paymentEntity) {
        return methodRepository.save(paymentEntity);
    }

    public Boolean delete(String uuid) {
        try {
            methodRepository.deleteById(uuid);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}

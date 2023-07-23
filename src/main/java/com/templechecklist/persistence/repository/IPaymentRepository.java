package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.PaymentEntity;
import org.hibernate.query.criteria.JpaSearchedCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<PaymentEntity, String> {
}

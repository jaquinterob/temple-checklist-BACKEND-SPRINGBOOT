package com.templechecklist.web.controller;

import com.templechecklist.persistence.entity.PaymentEntity;
import com.templechecklist.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping
    ResponseEntity<List<PaymentEntity>> getAll() {
        List<PaymentEntity> travelEntities = paymentService.getAll();
        if (travelEntities.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(travelEntities);
    }

    @PostMapping
    ResponseEntity<PaymentEntity> save(@RequestBody PaymentEntity paymentEntity) {
        paymentEntity = paymentService.save(paymentEntity);
        if (paymentEntity == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(paymentEntity);
    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<PaymentEntity> delete(@PathVariable String uuid) {
        Boolean deleted = paymentService.delete(uuid);
        if (deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

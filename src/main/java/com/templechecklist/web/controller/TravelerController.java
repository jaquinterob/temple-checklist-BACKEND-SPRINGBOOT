package com.templechecklist.web.controller;

import com.templechecklist.persistence.entity.TravelerEntity;
import com.templechecklist.service.TravelerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/traveler")
public class TravelerController {
    @Autowired
    TravelerService travelerService;

    @GetMapping
    ResponseEntity<List<TravelerEntity>> getAll() {
        List<TravelerEntity> travelEntities = travelerService.getAll();
        if (travelEntities.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(travelEntities);
    }

    @PostMapping
    ResponseEntity<TravelerEntity> save(@RequestBody TravelerEntity travelerEntity) {
        travelerEntity = travelerService.save(travelerEntity);
        if (travelerEntity == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(travelerEntity);
    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<TravelerEntity> delete(@PathVariable String uuid) {
        Boolean deleted = travelerService.delete(uuid);
        if (deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/filter/{filter}")
    ResponseEntity<List<TravelerEntity>> getTravelerWithSomepayment(@PathVariable String filter) {
        switch (filter) {
            case "some-payment" -> {
                return ResponseEntity.ok(travelerService.getTravelerWithSomePayment());
            }
            case "no-payments" -> {
                return ResponseEntity.ok(travelerService.getTravelerWithOutPayment());
            }
            default -> {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
    }
}

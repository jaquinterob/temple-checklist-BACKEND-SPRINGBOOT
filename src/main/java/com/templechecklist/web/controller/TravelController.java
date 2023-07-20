package com.templechecklist.web.controller;

import com.templechecklist.persistence.entity.TravelEntity;
import com.templechecklist.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/travel")
public class TravelController {
    @Autowired
    TravelService travelService;

    @GetMapping
    ResponseEntity<List<TravelEntity>> getAll() {
        List<TravelEntity> travelEntities = travelService.getAll();
        if (travelEntities.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(travelEntities);
    }

    @PostMapping
    ResponseEntity<TravelEntity> save(@RequestBody TravelEntity travelEntity) {
        travelEntity = travelService.save(travelEntity);
        if (travelEntity == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(travelEntity);
    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<TravelEntity> delete(@PathVariable String uuid) {
        Boolean deleted = travelService.delete(uuid);
        if (deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

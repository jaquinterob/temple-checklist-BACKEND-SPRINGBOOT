package com.templechecklist.web.controller;

import com.templechecklist.persistence.entity.TravelerTypeEntity;
import com.templechecklist.service.TravelerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/travelerType")
public class TravelerTypeController {
    @Autowired
    TravelerTypeService travelerTypeService;

    @GetMapping
    ResponseEntity<List<TravelerTypeEntity>> getAll() {
        List<TravelerTypeEntity> travelerTypeEntities = travelerTypeService.getAll();
        if (travelerTypeEntities.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(travelerTypeEntities);
    }

    @PostMapping
    ResponseEntity<TravelerTypeEntity> save(@RequestBody TravelerTypeEntity travelerTypeEntity) {
        travelerTypeEntity = travelerTypeService.save(travelerTypeEntity);
        if (travelerTypeEntity == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(travelerTypeEntity);

    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<TravelerTypeEntity> delete(@PathVariable String uuid) {
        Boolean deleted = travelerTypeService.delete(uuid);
        if (deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}

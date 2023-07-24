package com.templechecklist.web.controller;

import com.templechecklist.persistence.entity.DocumentTypeEntity;
import com.templechecklist.persistence.entity.MethodEntity;
import com.templechecklist.service.DocumentTypeService;
import com.templechecklist.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/method")
public class MethodController {
    @Autowired
    private MethodService methodService;

    @GetMapping
    ResponseEntity<List<MethodEntity>> getAll() {
        List<MethodEntity> methodEntities = methodService.getAll();
        if (methodEntities.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(methodEntities);
    }

    @PostMapping
    ResponseEntity<MethodEntity> save(@RequestBody MethodEntity methodEntity) {
        methodEntity = methodService.save(methodEntity);
        if (methodEntity == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(methodEntity);
    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<?> delete(@PathVariable String uuid) {
        Boolean deleted = methodService.delete(uuid);
        if (deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}

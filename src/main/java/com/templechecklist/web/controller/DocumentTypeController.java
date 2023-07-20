package com.templechecklist.web.controller;

import com.templechecklist.persistence.entity.DocumentTypeEntity;
import com.templechecklist.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/documentType")
public class DocumentTypeController {
    @Autowired
    private DocumentTypeService documentTypeService;

    @GetMapping
    ResponseEntity<List<DocumentTypeEntity>> getAll() {
        List<DocumentTypeEntity> documentTypeEntities = documentTypeService.getAll();
        if (documentTypeEntities.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(documentTypeEntities);
    }

    @PostMapping
    ResponseEntity<DocumentTypeEntity> save(@RequestBody DocumentTypeEntity documentType) {
        documentType = documentTypeService.save(documentType);
        if (documentType == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(documentType);
    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<?> delete(@PathVariable String uuid) {
        Boolean deleted = documentTypeService.delete(uuid);
        if (deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}

package com.templechecklist.service;

import com.templechecklist.persistence.entity.DocumentTypeEntity;
import com.templechecklist.persistence.repository.IDocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService {

    @Autowired
    IDocumentTypeRepository documentTypeRepository;

    public List<DocumentTypeEntity> getAll() {
        return documentTypeRepository.findAll();
    }

    public DocumentTypeEntity save(DocumentTypeEntity documentType) {
        return documentTypeRepository.save(documentType);
    }

    public Boolean delete(String uuid) {
        try {
            documentTypeRepository.deleteById(uuid);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}

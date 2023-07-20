package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.DocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentTypeRepository extends JpaRepository<DocumentTypeEntity,String> {

}

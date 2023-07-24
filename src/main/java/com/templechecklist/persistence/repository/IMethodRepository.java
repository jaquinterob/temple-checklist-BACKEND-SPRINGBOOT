package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.MethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMethodRepository extends JpaRepository<MethodEntity,String> {
}

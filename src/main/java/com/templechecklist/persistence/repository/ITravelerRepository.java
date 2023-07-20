package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.TravelerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITravelerRepository extends JpaRepository<TravelerEntity, String> {
}

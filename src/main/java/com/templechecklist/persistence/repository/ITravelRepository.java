package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITravelRepository extends JpaRepository<TravelEntity, String> {
}

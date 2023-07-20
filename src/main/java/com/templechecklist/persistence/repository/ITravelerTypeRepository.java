package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.TravelerTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITravelerTypeRepository extends JpaRepository<TravelerTypeEntity,String> {
}

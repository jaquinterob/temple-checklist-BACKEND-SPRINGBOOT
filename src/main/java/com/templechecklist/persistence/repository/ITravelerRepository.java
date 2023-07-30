package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.TravelerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITravelerRepository extends JpaRepository<TravelerEntity, String> {

}

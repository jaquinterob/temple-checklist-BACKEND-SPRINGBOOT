package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.TravelerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITravelerRepository extends JpaRepository<TravelerEntity, String> {

    @Query(value = "select t.* from traveler t , payment p  where t.uuid = p.traveler_id", nativeQuery = true)
    List<TravelerEntity> getTravelerWithSomePayment();

    @Query(value = "select t.* from traveler t , payment p  where not(t.uuid = p.traveler_id);", nativeQuery = true)
    List<TravelerEntity> getTravelerWithOutPayment();
}

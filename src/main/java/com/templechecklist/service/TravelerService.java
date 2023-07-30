package com.templechecklist.service;

import com.templechecklist.persistence.entity.TravelerEntity;
import com.templechecklist.persistence.repository.ITravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelerService {
    @Autowired
    ITravelerRepository travelerRepository;

    public List<TravelerEntity> getAll() {
        return travelerRepository.findAll();
    }

    public TravelerEntity save(TravelerEntity travelerEntity) {
        return travelerRepository.save(travelerEntity);
    }

    public Boolean delete(String uuid) {
        try {
            travelerRepository.deleteById(uuid);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}

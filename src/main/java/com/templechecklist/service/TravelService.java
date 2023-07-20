package com.templechecklist.service;

import com.templechecklist.persistence.entity.TravelEntity;
import com.templechecklist.persistence.repository.ITravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelService {
    @Autowired
    ITravelRepository travelRepository;

    public List<TravelEntity> getAll() {
        return travelRepository.findAll();
    }

    public TravelEntity save(TravelEntity travelEntity) {
        return travelRepository.save(travelEntity);
    }

    public Boolean delete(String uuid) {
        try {
            travelRepository.deleteById(uuid);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}

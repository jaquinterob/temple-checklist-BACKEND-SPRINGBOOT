package com.templechecklist.service;

import com.templechecklist.persistence.entity.TravelerTypeEntity;
import com.templechecklist.persistence.repository.ITravelerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelerTypeService {
    @Autowired
    ITravelerTypeRepository travelerTypeRepository;
    public List<TravelerTypeEntity> getAll(){
        return travelerTypeRepository.findAll();
    }

    public TravelerTypeEntity save(TravelerTypeEntity travelerTypeEntity){
        return travelerTypeRepository.save(travelerTypeEntity);
    }

    public Boolean delete(String uuid){
        try {
            travelerTypeRepository.deleteById(uuid);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}

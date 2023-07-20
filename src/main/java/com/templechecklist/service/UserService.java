package com.templechecklist.service;

import com.templechecklist.persistence.entity.UserEntity;
import com.templechecklist.persistence.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public List<UserEntity> getAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Boolean delete(String uuid) {
        try {
            userRepository.deleteById(uuid);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public Boolean login(String user, String pass) {
        UserEntity userEntity = userRepository.findByUserAndPassAndActiveTrue(user, pass);
        return userEntity != null;
    }

}

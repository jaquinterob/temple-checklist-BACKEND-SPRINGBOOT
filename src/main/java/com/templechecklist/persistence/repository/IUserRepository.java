package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,String> {
}

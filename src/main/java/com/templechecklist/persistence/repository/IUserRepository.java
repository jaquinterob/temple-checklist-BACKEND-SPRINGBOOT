package com.templechecklist.persistence.repository;

import com.templechecklist.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends JpaRepository<UserEntity,String> {

//@Query(value = "select * from `user` where `user`=?1 and `pass`=?2",nativeQuery = true)
    UserEntity findByUserAndPassAndActiveTrue(String user,String pass);
}

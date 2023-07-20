package com.templechecklist.web.controller;

import com.templechecklist.persistence.entity.TravelerTypeEntity;
import com.templechecklist.persistence.entity.UserEntity;
import com.templechecklist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<UserEntity>> getAll() {
        List<UserEntity> userEntities = userService.getAll();
        if (userEntities.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(userEntities);
    }

    @PostMapping
    ResponseEntity<UserEntity> save(@RequestBody UserEntity userEntity) {
        userEntity = userService.save(userEntity);
        if (userEntity == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(userEntity);

    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<TravelerTypeEntity> delete(@PathVariable String uuid) {
        Boolean deleted = userService.delete(uuid);
        if (deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

}

package com.prototype.first.repository;


import com.prototype.first.dto.UserDto;
import com.prototype.first.entity.User;
import com.prototype.first.mappers.UserMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class UserDao {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void saveUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        entityManager.persist(user);
    }

    public UserDto getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        return UserMapper.toDto(user);
    }

}


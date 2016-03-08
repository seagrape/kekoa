package com.sina.kekoa.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.sina.kekoa.entity.User;

public interface UserDao extends Repository<User, Long> {

    Page<User> findAll(Pageable pageable);

    User findByUsername(String name);
    
//    @Query( " select u from User u " )
//    List<User> getList();

}
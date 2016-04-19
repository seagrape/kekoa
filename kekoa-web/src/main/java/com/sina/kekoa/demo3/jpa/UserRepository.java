package com.sina.kekoa.demo3.jpa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserJPA, Long> {

    Page<UserJPA> findAll(Pageable pageable);

    UserJPA findByName(String name);

}
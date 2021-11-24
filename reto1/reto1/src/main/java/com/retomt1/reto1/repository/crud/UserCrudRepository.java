package com.retomt1.reto1.repository.crud;


import java.util.Optional;

import com.retomt1.reto1.model.User;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author karent_saenz
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
   
} 
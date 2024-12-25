package com.goyum.posBE.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goyum.posBE.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    
    Optional<User> findByUsername(String username);
}

package com.baldosrl.tambuto.repositories;

import com.baldosrl.tambuto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    Optional<User> getUserById(int id);
}

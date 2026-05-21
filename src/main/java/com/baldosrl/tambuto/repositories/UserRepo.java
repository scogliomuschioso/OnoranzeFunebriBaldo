package com.baldosrl.tambuto.repositories;

import com.baldosrl.tambuto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);

}

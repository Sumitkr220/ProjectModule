package com.example.Registration.repository;

import com.example.Registration.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {
//    UserDTO findByUserId(String userId);
}
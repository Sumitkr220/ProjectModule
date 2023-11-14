package com.example.Registration.service;

import com.example.Registration.customException.UserNotFoundException;
import com.example.Registration.repository.UserRepository;
import com.example.Registration.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(Long id,String userId, String password,String state,String country,
                            String firstName,String lastName,String authId) {
        UserDTO userDTO=UserDTO.builder()
                .id(id)
                .userEmail(userId)
                .state(state)
                .country(country)
                .firstName(firstName)
                .lastName(lastName)
                .authId(authId)
//                .passwordHash(passwordEncoder.encode(password))
                .passwordHash(password)
                .build();
        userRepository.save(userDTO);
    }

    public Optional<UserDTO> findByUserId(Long userId) throws UserNotFoundException {
        //        Optional<UserDTO> userDTO= userRepository.findById(userId);
        return userRepository.findById(userId);
//        return Optional.ofNullable(userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found")));
    }

    public List<UserDTO> getAllUser(){
        return userRepository.findAll();
    }
}

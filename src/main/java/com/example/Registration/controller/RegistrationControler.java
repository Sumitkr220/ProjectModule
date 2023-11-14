package com.example.Registration.controller;

import com.example.Registration.customException.UserNotFoundException;
import com.example.Registration.model.RegistrationDao;
import com.example.Registration.model.UserDTO;
import com.example.Registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class RegistrationControler {

    private final UserService userService;

    @Autowired
    public RegistrationControler(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationDao request) throws UserNotFoundException {
        String userId = request.getUserEmail();
        String password = request.getPasswordHash();
        Long id=request.getId();
        String state=request.getState();
        String country=request.getCountry();
        String firstName=request.getFirstName();
        String lastName=request.getLastName();
        String authId=request.getAuthId();
        // Check if user already exists
        if (userService.findByUserId(id).isPresent()) {
            return "User already exists";
        }
        // Save the user
        userService.saveUser(id, userId,  password, state, country,
                     firstName, lastName, authId);
        return "User registered successfully";
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
       List<UserDTO> userDTOS= userService.getAllUser();
       return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws UserNotFoundException {
        Optional<UserDTO> userDTO=userService.findByUserId(id);
        if(userDTO.isEmpty()) throw new UserNotFoundException("User Not Found");
        return new ResponseEntity<>(userDTO.get(),HttpStatus.OK);
    }
}

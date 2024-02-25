package com.green.validationAndExceptionHandling.controller;

import com.green.validationAndExceptionHandling.dto.UserRequest;
import com.green.validationAndExceptionHandling.entity.User;
import com.green.validationAndExceptionHandling.excepitons.UserNotFoundException;
import com.green.validationAndExceptionHandling.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        User user = userService.saveUser(userRequest);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> saveUser(@PathVariable int id) throws UserNotFoundException {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}

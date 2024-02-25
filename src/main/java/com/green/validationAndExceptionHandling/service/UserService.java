package com.green.validationAndExceptionHandling.service;

import com.green.validationAndExceptionHandling.dto.UserRequest;
import com.green.validationAndExceptionHandling.entity.User;
import com.green.validationAndExceptionHandling.excepitons.UserNotFoundException;
import com.green.validationAndExceptionHandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findById(id);

        if(user!=null)
        {
            return user;
        }
        else {
            throw new UserNotFoundException("user not found with id: "+id);
        }

    }

    public User saveUser(@RequestBody UserRequest userRequest){
        User user = User.build(0,userRequest.getName(),userRequest.getEmail(),
                userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());
        return userRepository.save(user);
    }
}

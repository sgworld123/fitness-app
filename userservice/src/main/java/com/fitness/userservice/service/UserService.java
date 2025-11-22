package com.fitness.userservice.service;

import com.fitness.userservice.Repositories.UserRepository;
import com.fitness.userservice.dto.RegisterUserResponse;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserResponse register(RegisterUserResponse user) {

        if(userRepository.findByEmail(user.getEmail()))
        {
            throw new RuntimeException("Email already exixts");
        }

        User user1 = new User();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastname());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());

        User savedUser = userRepository.save(user1);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());
        return userResponse;
    }

    public UserResponse findById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
        {
            User savedUser = user.get();
            UserResponse userResponse = new UserResponse();
            userResponse.setId(savedUser.getId());
            userResponse.setEmail(savedUser.getEmail());
            userResponse.setEmail(savedUser.getEmail());
            userResponse.setFirstName(savedUser.getFirstName());
            userResponse.setLastName(savedUser.getLastName());
            userResponse.setCreatedAt(savedUser.getCreatedAt());
            userResponse.setUpdatedAt(savedUser.getUpdatedAt());
            return userResponse;
        }
        else
        {
            throw new RuntimeException("User not found");
        }
    }
}

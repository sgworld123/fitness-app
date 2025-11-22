package com.fitness.userservice.controller;

//import com.fitness.userservice.dto.RegisterUser;
import com.fitness.userservice.dto.RegisterUserResponse;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
//    few end points  : register user , find user with certain field , remove user
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterUserResponse user)
    {
        return ResponseEntity.ok(userService.register(user));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getProfile(@PathVariable String userId)
    {
        return ResponseEntity.ok(userService.findById(userId));
    }
}

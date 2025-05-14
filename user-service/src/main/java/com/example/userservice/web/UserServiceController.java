package com.example.userservice.web;

import com.example.userservice.application.UserService;
import com.example.userservice.domain.dtos.UserRegisterRequestDto;
import com.example.userservice.domain.dtos.UserRegisterResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserServiceController
{
    private final UserService userService;

    public UserServiceController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<UserRegisterResponseDto> post(@RequestBody UserRegisterRequestDto dto)
    {
        return ResponseEntity.ok(userService.registerUser(dto));
    }
}

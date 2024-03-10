package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.LoginDto;
import com.backend.backend.dto.UserDto;
import com.backend.backend.response.LoginResp;
import com.backend.backend.service.UserService;


@RestController
// @CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    public UserService userService;
    //Build Add user Rest API
    @PostMapping(path="/register")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        String savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    @GetMapping(path="/find/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(path="/login")
    public ResponseEntity<LoginResp> LoginUser(@RequestBody LoginDto loginDto){
        LoginResp loginResp = userService.getUserByLogin(loginDto);
        return ResponseEntity.ok(loginResp);
    }
}

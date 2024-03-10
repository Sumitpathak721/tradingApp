package com.backend.backend.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.dto.LoginDto;
import com.backend.backend.dto.UserDto;
import com.backend.backend.entity.User;
import com.backend.backend.exception.ResourceNotFoundException;
import com.backend.backend.mapper.userMapper;
import com.backend.backend.repository.UserRepo;
import com.backend.backend.response.LoginResp;
import com.backend.backend.service.JWTService;
import com.backend.backend.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class userImpl implements UserService{

    private UserRepo userRepo;

    @Autowired
    public JWTService jwtService;

    @Override
    public String createUser(UserDto userDto){
        User user = userMapper.maptoUser(userDto);
        user.setBalance(100);
        userRepo.save(user);
        return "User Created Successfully";
    }

    @Override
    public UserDto getUserById(Long userId){
        User user =  userRepo.findById(userId).orElseThrow(
            ()->new ResourceNotFoundException("User does not exisit with given ID : "+userId));
        return userMapper.maptoUserDto(user);
    }

    @Override
    public LoginResp getUserByLogin(LoginDto loginDto){
        String email = loginDto.getEmail();
        User user1 = userRepo.findByEmail(email);

        if(user1!=null){
            Optional<User> user = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
            if(user.isPresent()){
                String token = jwtService.generateToken(String.valueOf(user1.getId()), user1.getName());
                return new LoginResp("Login Success",true,user1.getId(),user1.getName(),token);
            }else{
                return new LoginResp("Login Failed",false);
            }
        }else{
            return new LoginResp("Invalid Email",false);
        }
    }
}

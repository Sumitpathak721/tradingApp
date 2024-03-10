package com.backend.backend.service;

import com.backend.backend.dto.LoginDto;
import com.backend.backend.dto.UserDto;
import com.backend.backend.response.LoginResp;

public interface UserService {
    String createUser(UserDto userDto);
    UserDto getUserById(Long userID);
    LoginResp getUserByLogin(LoginDto loginDto);
}

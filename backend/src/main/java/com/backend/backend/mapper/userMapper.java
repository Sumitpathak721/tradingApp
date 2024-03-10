package com.backend.backend.mapper;

import com.backend.backend.dto.UserDto;
import com.backend.backend.entity.User;

public class userMapper {
    public static UserDto maptoUserDto(User user){
        return new UserDto(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getBalance()
        );
    }

    public static User maptoUser(UserDto userDto){
        return new User(
            userDto.getId(),
            userDto.getName(),
            userDto.getEmail(),
            userDto.getPassword(),
            userDto.getBalance()
        );
    }
}

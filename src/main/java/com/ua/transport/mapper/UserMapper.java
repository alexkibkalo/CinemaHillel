package com.ua.transport.mapper;

import com.ua.model.User;
import com.ua.transport.dto.UserIncomeDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User dtoToEntity(UserIncomeDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }
}

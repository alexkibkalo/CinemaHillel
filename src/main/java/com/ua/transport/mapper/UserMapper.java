package com.ua.transport.mapper;

import com.ua.model.User;
import com.ua.transport.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = {TicketMapper.class}, componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User entity);

    User toEntity(UserDTO dto);

    void update(UserDTO dto, @MappingTarget User user);
}

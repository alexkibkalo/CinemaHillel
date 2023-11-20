package com.ua.transport.mapper;

import com.ua.model.Ticket;
import com.ua.transport.dto.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "userId", source = "entity.user.id")
    @Mapping(target = "movieId", source = "entity.movie.id")
    TicketDTO toDto(Ticket entity);

    Ticket toEntity(TicketDTO dto);
}

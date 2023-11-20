package com.ua.service.user;

import com.ua.transport.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    void create(UserDTO dto);

    UserDTO getById(Long userId);

    Page<UserDTO> getAll(Pageable pageable);

    @Transactional(readOnly = true)
    List<UserDTO> getAllSorted();

    void update(Long userId, UserDTO user);

    void delete(Long userId);
}

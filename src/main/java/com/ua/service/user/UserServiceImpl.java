package com.ua.service.user;

import com.ua.model.User;
import com.ua.repository.UserRepository;
import com.ua.transport.dto.UserDTO;
import com.ua.transport.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void create(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        userRepository.save(user);
    }

    @Override
    public UserDTO getById(Long userId) {
        User user = userRepository.getUserById(userId);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> getAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return null;
//        return userMapper.toPageDto(userPage);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllSorted() {
        Sort sort = Sort.by(Sort.Order.asc("id"));
        return userRepository.findAll(sort).stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public void update(Long userId, UserDTO incomingUser) {
        User user = userRepository.getUserById(userId);
        userMapper.update(incomingUser, user);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}

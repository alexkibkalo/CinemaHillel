package com.ua.service.user;

import com.ua.exception.UserNotFoundException;
import com.ua.exception.UserUnauthorized;
import com.ua.model.User;
import com.ua.repository.UserRepository;
import com.ua.transport.dto.UserDTO;
import com.ua.transport.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.ua.util.ExceptionMessages.UNAUTHORIZED;
import static com.ua.util.ExceptionMessages.USER_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void create(UserDTO dto) {
        var user = userMapper.toEntity(dto);
        userRepository.save(user);
    }

    @Override
    public UserDTO getById(Long userId) {
        logger.info("Getting user by id: " + userId);
        var user = Optional.ofNullable(userRepository.getUserById(userId)).orElseThrow(() -> {
            logger.warn(USER_NOT_FOUND);
            throw new UserNotFoundException();
        });
        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> getAll(Pageable pageable) {
        var userPage = userRepository.findAll(pageable);
        return null;
//        return userMapper.toPageDto(userPage);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllSorted() {
        var sort = Sort.by(Sort.Order.asc("id"));
        return userRepository.findAll(sort).stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public void update(Long userId, UserDTO incomingUser) {
        var user = userRepository.getUserById(userId);
        userMapper.update(incomingUser, user);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}

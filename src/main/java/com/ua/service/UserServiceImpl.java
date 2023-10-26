package com.ua.service;

import com.ua.model.User;
import com.ua.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long userId, User incomingUser) {
        User user = getById(userId);

        if(incomingUser.getJob() != null){
            user.setJob(incomingUser.getJob());
        }
        if(incomingUser.getSalary() != null){
            user.setSalary(incomingUser.getSalary());
        }

        return userRepository.save(user);
    }

    @Override
    public void delete(Long userId) {
        User user = getById(userId);
        userRepository.delete(user);
    }
}

package com.ua.controller;

import com.ua.model.User;
import com.ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/get/{userId}")
    public User getById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @GetMapping("/get")
    public ResponseEntity<Page<User>> getAll(Pageable pageable) {
        return ResponseEntity.ok(userService.getAll(pageable));
    }

    @GetMapping("/get/sorted")
    public List<User> getAll() {
        return userService.getAllSorted();
    }

    @PutMapping("/update/{userId}")
    public User update(@PathVariable Long userId, @RequestBody User user) {
        return userService.update(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }
}

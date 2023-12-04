package com.ua.controller;

import com.ua.service.authorization.AuthorizationService;
import com.ua.service.user.UserService;
import com.ua.transport.dto.UserDTO;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "User Controller API")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void create(@RequestBody UserDTO user){
        userService.create(user);
    }

    @GetMapping("/{userId}")
    public UserDTO getById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(userService.getAll(pageable));
    }

    @GetMapping("/sorted")
    public List<UserDTO> getAll() {
        return userService.getAllSorted();
    }

    @PutMapping("/{userId}")
    public void update(@PathVariable Long userId, @RequestBody UserDTO user) {
        userService.update(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }
}

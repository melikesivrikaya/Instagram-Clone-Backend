package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    private final UserServiceImpl userService;
    @GetMapping
    @Override
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping("{id}")
    @Override
    public Optional<User> getById(@PathVariable Long id) {
        return userService.getById(id);
    }
    @PostMapping
    @Override
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    @PutMapping
    @Override
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @PostMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}

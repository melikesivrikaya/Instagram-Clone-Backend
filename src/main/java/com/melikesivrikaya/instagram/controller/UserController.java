package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.response.UserResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserController {
    List<UserResponse> getAll();
    Optional<User> getById(Long id);
    UserResponse create( User user);
    UserResponse update( User user);
    boolean deleteById( Long id);
}

package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserController {
    List<User> getAll();
    Optional<User> getById(Long id);
    User create( User user);
    User update( User user);
    boolean deleteById( Long id);
}

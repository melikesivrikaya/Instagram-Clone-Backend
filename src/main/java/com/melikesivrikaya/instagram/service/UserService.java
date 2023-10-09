package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> getById(Long id);
    User create( User user);
    User update( User user);
    boolean deleteById( Long id);
}

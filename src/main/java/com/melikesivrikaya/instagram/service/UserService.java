package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> getAll();
    Optional<User> getById(Long id);
    UserResponse create( User user);
    UserResponse update( User user);
    boolean deleteById( Long id);
    List<UserResponse> getAllWithoutFriend(Long userId);
}

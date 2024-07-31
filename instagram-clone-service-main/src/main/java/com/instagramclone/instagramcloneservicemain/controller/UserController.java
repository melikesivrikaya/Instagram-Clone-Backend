package com.instagramclone.instagramcloneservicemain.controller;


import com.instagramclone.instagramcloneservicemain.dto.response.UserResponse;
import com.instagramclone.instagramcloneservicemain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserController {
    List<UserResponse> getAll();
    Optional<User> getById(Long id);
    UserResponse create( User user);
    UserResponse update( User user);
    boolean deleteById( Long id);
    List<UserResponse> getAllWithoutFriend(Long userId);
}

package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.request.CreatePostRequest;
import com.melikesivrikaya.instagram.request.UpdatePostRequest;

import java.util.List;
import java.util.Optional;

public interface PostController {
    List<Post> getAll();
    Optional<Post> getById(Long id);
    Post create(CreatePostRequest post);
    Post update(UpdatePostRequest post);
    boolean deleteById(Long id);
}

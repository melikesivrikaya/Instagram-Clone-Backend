package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;

import java.util.List;
import java.util.Optional;

public interface PostController {
    List<Post> getAll();
    Optional<Post> getById(Long id);
    Post create( Post post);
    Post update(Post post);
    boolean deleteById(Long id);
}

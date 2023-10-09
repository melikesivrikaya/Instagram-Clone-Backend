package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAll();
    Optional<Post> getById(Long id);
    Post create( Post post);
    Post update(Post post);
    boolean deleteById(Long id);
}

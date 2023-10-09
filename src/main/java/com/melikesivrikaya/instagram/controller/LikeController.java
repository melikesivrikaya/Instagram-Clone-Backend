package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.model.Post;

import java.util.List;
import java.util.Optional;

public interface LikeController {
    List<Like> getAll();
    Optional<Like> getById(Long id);
    Like create(Like like);
    Like update(Like like);
    boolean deleteById(Long id);
}

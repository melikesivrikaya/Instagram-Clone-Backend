package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<Like> getAll();
    Optional<Like> getById(Long id);
    Like create(Like like);
    Like update(Like like);
    boolean deleteById(Long id);
}

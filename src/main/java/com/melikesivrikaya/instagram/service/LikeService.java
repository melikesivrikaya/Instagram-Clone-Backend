package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.request.CreateLikeRequest;
import com.melikesivrikaya.instagram.response.LikeResponse;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAll();
    Optional<Like> getById(Long id);
    LikeResponse create(CreateLikeRequest like);
    Like update(Like like);
    boolean deleteById(Long id);
}

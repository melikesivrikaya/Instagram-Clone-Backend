package com.instagramclone.instagramcloneservicemain.service;


import com.instagramclone.instagramcloneservicemain.dto.request.CreateLikeRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.LikeResponse;
import com.instagramclone.instagramcloneservicemain.model.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAll();
    Optional<Like> getById(Long id);
    LikeResponse create(CreateLikeRequest like);
    Like update(Like like);
    boolean deleteById(Long id);
}

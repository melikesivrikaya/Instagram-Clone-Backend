package com.instagramclone.likeservicemain.service;



import com.instagramclone.likeservicemain.dto.response.LikeResponse;
import com.instagramclone.likeservicemain.dto.resquest.CreateLikeRequest;
import com.instagramclone.likeservicemain.model.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAll();
    Optional<Like> getById(Long id);
    LikeResponse create(CreateLikeRequest like);
    Like update(Like like);
    boolean deleteById(Long id);
}

package com.instagramclone.instagramcloneservicemain.service;


import com.instagramclone.instagramcloneservicemain.dto.request.FriendRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.FriendResponse;
import com.instagramclone.instagramcloneservicemain.model.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService {
    List<FriendResponse> getAll();
    Optional<Friend> getById(Long id);
    FriendResponse create(FriendRequest request);
    FriendResponse update(FriendRequest request);
    boolean deleteById(Long id);
    List<FriendResponse> getAllByUserId(Long userId);

    FriendResponse deleteFriends(FriendRequest request);
}

package com.instagramclone.instagramcloneservicemain.controller;

import com.instagramclone.instagramcloneservicemain.dto.request.FriendRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.FriendResponse;
import com.instagramclone.instagramcloneservicemain.model.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendController {
    List<FriendResponse> getAll();
    Optional<Friend> getById(Long id);
    boolean deleteById(Long id);
    List<FriendResponse> getAllByUserId(Long userId);
    FriendResponse friendHandleState(FriendRequest request);
}

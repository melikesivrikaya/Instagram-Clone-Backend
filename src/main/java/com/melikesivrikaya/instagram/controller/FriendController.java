package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Friend;
import com.melikesivrikaya.instagram.request.FriendRequest;
import com.melikesivrikaya.instagram.response.FriendResponse;

import java.util.List;
import java.util.Optional;

public interface FriendController {
    List<FriendResponse> getAll();
    Optional<Friend> getById(Long id);
    boolean deleteById(Long id);
    List<FriendResponse> getAllByUserId(Long userId);
    FriendResponse friendHandleState(FriendRequest request);
}

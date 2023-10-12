package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Friend;
import com.melikesivrikaya.instagram.request.CreateFriendRequest;
import com.melikesivrikaya.instagram.response.FriendResponse;

import java.util.List;
import java.util.Optional;

public interface FriendController {
    List<Friend> getAll();
    Optional<Friend> getById(Long id);
    FriendResponse create(CreateFriendRequest request);
    Friend update(Friend friend);
    boolean deleteById(Long id);
}

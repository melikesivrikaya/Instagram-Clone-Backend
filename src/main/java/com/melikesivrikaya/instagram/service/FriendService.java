package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Friend;
import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.request.CreateFriendRequest;
import com.melikesivrikaya.instagram.request.CreateLikeRequest;
import com.melikesivrikaya.instagram.response.FriendResponse;
import com.melikesivrikaya.instagram.response.LikeResponse;

import java.util.List;
import java.util.Optional;

public interface FriendService {
    List<Friend> getAll();
    Optional<Friend> getById(Long id);
    FriendResponse create(CreateFriendRequest request);
    Friend update(Friend friend);
    boolean deleteById(Long id);
}

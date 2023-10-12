package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Friend;
import com.melikesivrikaya.instagram.request.FriendRequest;
import com.melikesivrikaya.instagram.response.FriendResponse;

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

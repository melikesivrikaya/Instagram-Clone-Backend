package com.melikesivrikaya.instagram.request;

import lombok.Data;

@Data
public class CreateFriendRequest {
    private Long userId,friendId;
}

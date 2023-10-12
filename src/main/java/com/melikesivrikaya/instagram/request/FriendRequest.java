package com.melikesivrikaya.instagram.request;

import com.melikesivrikaya.instagram.model.FriendRequestState;
import lombok.Data;

@Data
public class FriendRequest {
    private Long userId,friendId;
    private FriendRequestState state;
}

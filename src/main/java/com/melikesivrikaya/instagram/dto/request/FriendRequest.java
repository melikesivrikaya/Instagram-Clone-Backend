package com.melikesivrikaya.instagram.dto.request;

import com.melikesivrikaya.instagram.model.enums.FriendRequestState;
import lombok.Data;

@Data
public class FriendRequest {
    private Long userId,friendId;
    private FriendRequestState state;
}

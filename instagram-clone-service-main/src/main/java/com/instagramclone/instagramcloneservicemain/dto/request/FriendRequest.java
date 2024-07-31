package com.instagramclone.instagramcloneservicemain.dto.request;

import com.instagramclone.instagramcloneservicemain.model.enums.FriendRequestState;
import lombok.Data;

@Data
public class FriendRequest {
    private Long userId,friendId;
    private FriendRequestState state;
}

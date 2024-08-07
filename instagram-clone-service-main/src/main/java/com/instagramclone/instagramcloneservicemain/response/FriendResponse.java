package com.instagramclone.instagramcloneservicemain.response;

import com.instagramclone.instagramcloneservicemain.model.Friend;
import lombok.Data;

@Data
public class FriendResponse {
    private Long id,userId,friendId;
    private String firstname,lastname,fullname,username;
    public FriendResponse(Friend friend){
        this.id = friend.getId();
        this.userId = friend.getUser().getId();
        this.friendId = friend.getFriendId();
        this.firstname = friend.getFirstname();
        this.lastname = friend.getLastname();
        this.fullname = friend.getFullname();
        this.username = friend.getUsername();
    }
}

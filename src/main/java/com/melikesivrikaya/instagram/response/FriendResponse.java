package com.melikesivrikaya.instagram.response;

import com.melikesivrikaya.instagram.model.Friend;
import lombok.Data;

@Data
public class FriendResponse {
    private Long id,userId;
    private String firstname,lastname,fullname,username;
    public FriendResponse(Friend friend){
        this.id = friend.getId();
        this.firstname = friend.getFirstname();
        this.lastname = friend.getLastname();
        this.fullname = friend.getFullname();
        this.username = friend.getUsername();
        this.userId = friend.getUser().getId();
    }
}

package com.melikesivrikaya.instagram.response;

import com.melikesivrikaya.instagram.model.Like;
import lombok.Data;

@Data
public class LikeResponse {
    private Long id,userId,postId;
    public LikeResponse(Like like){
        this.id = like.getId();
        this.userId = like.getUser().getId();
        this.postId = like.getPost().getId();
    }
}

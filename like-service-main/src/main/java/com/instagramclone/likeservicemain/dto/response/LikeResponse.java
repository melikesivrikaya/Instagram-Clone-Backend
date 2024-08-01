package com.instagramclone.likeservicemain.dto.response;

import com.instagramclone.likeservicemain.model.Like;
import lombok.Data;

@Data
public class LikeResponse {
    private Long id,userId,postId;
    public LikeResponse(Like like){
        this.id = like.getId();
        this.userId = like.getUserId();
        this.postId = like.getPostId();
    }
}

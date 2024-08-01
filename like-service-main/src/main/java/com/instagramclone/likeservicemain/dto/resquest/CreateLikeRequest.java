package com.instagramclone.likeservicemain.dto.resquest;

import lombok.Data;

@Data
public class CreateLikeRequest {
    private Long userId,postId;
}

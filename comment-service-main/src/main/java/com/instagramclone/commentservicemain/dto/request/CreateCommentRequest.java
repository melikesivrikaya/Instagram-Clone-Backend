package com.instagramclone.commentservicemain.dto.request;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private String text;
    private Long userId,postId;
}


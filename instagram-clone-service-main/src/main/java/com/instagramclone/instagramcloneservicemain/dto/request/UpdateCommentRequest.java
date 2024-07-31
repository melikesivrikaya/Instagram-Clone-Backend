package com.instagramclone.instagramcloneservicemain.dto.request;

import lombok.Data;

@Data
public class UpdateCommentRequest {
    private Long id;
    private String text;
}

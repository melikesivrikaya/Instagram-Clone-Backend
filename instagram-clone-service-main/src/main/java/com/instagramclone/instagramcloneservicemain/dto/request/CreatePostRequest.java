package com.instagramclone.instagramcloneservicemain.dto.request;
import lombok.Data;

@Data
public class CreatePostRequest {
    private String title,description,photourl;
    private Long userId;
}

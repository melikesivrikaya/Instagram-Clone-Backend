package com.instagramclone.postservicemain.dto.resquest;
import lombok.Data;

@Data
public class CreatePostRequest {
    private String title,description,photourl;
    private Long userId;
}

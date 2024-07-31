package com.instagramclone.instagramcloneservicemain.dto.request;

import lombok.Data;

@Data
public class CreateStoryRequest {
    private Long userId;
    private String storyUrl;

}

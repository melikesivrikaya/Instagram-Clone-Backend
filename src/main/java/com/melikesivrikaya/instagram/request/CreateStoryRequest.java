package com.melikesivrikaya.instagram.request;

import lombok.Data;

@Data
public class CreateStoryRequest {
    private Long userId;
    private String storyUrl;

}

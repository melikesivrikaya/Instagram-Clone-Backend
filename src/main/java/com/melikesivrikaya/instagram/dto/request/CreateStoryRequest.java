package com.melikesivrikaya.instagram.dto.request;

import lombok.Data;

@Data
public class CreateStoryRequest {
    private Long userId;
    private String storyUrl;

}

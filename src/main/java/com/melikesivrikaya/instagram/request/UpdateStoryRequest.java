package com.melikesivrikaya.instagram.request;

import lombok.Data;

@Data
public class UpdateStoryRequest {
    private Long id;
    private String storyUrl;
}

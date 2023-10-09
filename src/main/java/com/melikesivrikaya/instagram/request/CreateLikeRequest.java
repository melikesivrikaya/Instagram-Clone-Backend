package com.melikesivrikaya.instagram.request;

import lombok.Data;

@Data
public class CreateLikeRequest {
    private Long userId,postId;
}

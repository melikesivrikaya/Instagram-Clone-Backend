package com.melikesivrikaya.instagram.request;

import lombok.Data;

@Data
public class UpdateCommentRequest {
    private Long id;
    private String text;
}

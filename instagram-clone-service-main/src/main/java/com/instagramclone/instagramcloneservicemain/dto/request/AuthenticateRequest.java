package com.instagramclone.instagramcloneservicemain.dto.request;

import lombok.Data;

@Data
public class AuthenticateRequest {
    private String phone,username,email,password;
}

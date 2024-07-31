package com.instagramclone.instagramcloneservicemain.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username,email,password;
}

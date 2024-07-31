package com.melikesivrikaya.instagram.dto.request;

import lombok.Data;

@Data
public class AuthenticateRequest {
    private String phone,username,email,password;
}

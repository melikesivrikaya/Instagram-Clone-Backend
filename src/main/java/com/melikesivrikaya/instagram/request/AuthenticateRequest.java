package com.melikesivrikaya.instagram.request;

import lombok.Data;

@Data
public class AuthenticateRequest {
    private String phone,username,email,password;
}

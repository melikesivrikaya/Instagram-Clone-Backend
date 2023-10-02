package com.melikesivrikaya.instagram.request;

import lombok.Data;

@Data
public class AuthenticateRequest {
    private String email,password;
}

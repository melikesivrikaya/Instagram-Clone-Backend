package com.melikesivrikaya.instagram.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String fullname,username,email,password,phone;
}

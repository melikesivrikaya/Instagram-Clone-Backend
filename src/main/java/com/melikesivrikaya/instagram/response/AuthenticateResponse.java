package com.melikesivrikaya.instagram.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticateResponse {
    private String token;
}

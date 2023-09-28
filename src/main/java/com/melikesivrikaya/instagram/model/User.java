package com.melikesivrikaya.instagram.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Long id;
    private String firstname,lastname,email,password;
}

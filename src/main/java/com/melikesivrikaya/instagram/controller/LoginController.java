package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.request.AuthenticateRequest;
import com.melikesivrikaya.instagram.request.RegisterRequest;
import com.melikesivrikaya.instagram.response.AuthenticateResponse;
import com.melikesivrikaya.instagram.response.RegisterResponse;
import com.melikesivrikaya.instagram.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest reguest){
        return authenticationService.register(reguest);
    }
    @PostMapping("/authenticate")
    public AuthenticateResponse authenticate(@RequestBody AuthenticateRequest request){
        return authenticationService.authenticate(request);
    }
}

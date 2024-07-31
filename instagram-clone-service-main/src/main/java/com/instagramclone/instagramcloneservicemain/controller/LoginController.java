package com.instagramclone.instagramcloneservicemain.controller;

import com.instagramclone.instagramcloneservicemain.dto.request.AuthenticateRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.RegisterRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.AuthenticateResponse;
import com.instagramclone.instagramcloneservicemain.dto.response.RegisterResponse;
import com.instagramclone.instagramcloneservicemain.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
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

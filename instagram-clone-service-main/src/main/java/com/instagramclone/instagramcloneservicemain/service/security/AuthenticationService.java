package com.instagramclone.instagramcloneservicemain.service.security;

import com.instagramclone.instagramcloneservicemain.dto.request.AuthenticateRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.RegisterRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.AuthenticateResponse;
import com.instagramclone.instagramcloneservicemain.dto.response.RegisterResponse;
import com.instagramclone.instagramcloneservicemain.model.Role;
import com.instagramclone.instagramcloneservicemain.model.User;
import com.instagramclone.instagramcloneservicemain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public RegisterResponse register(RegisterRequest request){
        User user = new User();
        if (request.getUsername() != null){
            user.setUsername(request.getUsername());
        }
        if ((request.getPhone() != null)){
            user.setPhone(request.getPhone());
        }
        user.setFullName(request.getFullname());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setEmail(request.getEmail());
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new RegisterResponse(token);
    }

    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        Object principal = null;

        UserDetails user = null;

        if(request.getEmail() != null){
            user = userRepository.findByEmail(request.getEmail());
            principal = request.getEmail();
        }else if(request.getPhone() != null){
            user = userRepository.findByPhone(request.getPhone());
            principal = request.getPhone();
        } else if (request.getUsername() != null) {
            user = userRepository.findByUsername(request.getUsername());
            principal = request.getUsername();
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(principal, request.getPassword())
        );

        var jwtToken= jwtService.generateToken(user);
        return new AuthenticateResponse(jwtToken);
    }
}

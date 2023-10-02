package com.melikesivrikaya.instagram.service.security;

import com.melikesivrikaya.instagram.model.Role;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.AuthenticateRequest;
import com.melikesivrikaya.instagram.request.RegisterRequest;
import com.melikesivrikaya.instagram.response.AuthenticateResponse;
import com.melikesivrikaya.instagram.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setEmail(request.getEmail());
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new RegisterResponse(token);
    }

    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail() , request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail());
        var jwtToken= jwtService.generateToken(user);
        return new AuthenticateResponse(jwtToken);
    }
}

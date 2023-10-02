package com.melikesivrikaya.instagram.service.security;

import com.melikesivrikaya.instagram.model.Role;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.RegisterRequest;
import com.melikesivrikaya.instagram.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    private final JwtService jwtService;
    public RegisterResponse register(RegisterRequest request){
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        user.setEmail(request.getEmail());
        userRepository.save(user);
        return new RegisterResponse(jwtService.generateToken(user));
    }
}

package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserResponse create(User user) {
        return new UserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse update(User user) {
        return new UserResponse(userRepository.save(user));
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){

        }
        return false;
    }
}

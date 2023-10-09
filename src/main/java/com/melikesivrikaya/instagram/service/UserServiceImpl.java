package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
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

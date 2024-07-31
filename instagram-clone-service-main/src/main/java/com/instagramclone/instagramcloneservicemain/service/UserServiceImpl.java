package com.instagramclone.instagramcloneservicemain.service;

import com.instagramclone.instagramcloneservicemain.dto.response.FriendResponse;
import com.instagramclone.instagramcloneservicemain.dto.response.UserResponse;
import com.instagramclone.instagramcloneservicemain.model.User;
import com.instagramclone.instagramcloneservicemain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FriendService friendService;

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

    @Override
    public List<UserResponse> getAllWithoutFriend(Long userId) {
        List<UserResponse> users = getAll();
        List<FriendResponse> friends = friendService.getAllByUserId(userId);
        List<UserResponse> usersWithoutFriend = new ArrayList<>();
        users.forEach(user -> {
            if (!Objects.equals(user.getId(), userId)){
            boolean state = friends.stream().anyMatch(friend -> Objects.equals(friend.getFriendId(), user.getId()));
            if (!state){
                usersWithoutFriend.add(user);
            }}
        });
        return usersWithoutFriend;
    }
}

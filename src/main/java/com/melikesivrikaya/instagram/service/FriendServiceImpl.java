package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Friend;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.FriendRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.CreateFriendRequest;
import com.melikesivrikaya.instagram.response.FriendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    @Override
    public List<Friend> getAll() {
        return friendRepository.findAll();
    }

    @Override
    public Optional<Friend> getById(Long id) {
        return friendRepository.findById(id);
    }

    @Override
    public FriendResponse create(CreateFriendRequest request) {
        User user = userRepository.findById(request.getUserId()).get();
        User friend = userRepository.findById(request.getFriendId()).get();
        Friend usersFriend = new Friend(user,friend);
        Friend friendsUser = new Friend(friend,user);
        try {
            friendRepository.save(friendsUser);
            friendRepository.save(usersFriend);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new FriendResponse(usersFriend);
    }

    @Override
    public Friend update(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            friendRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}

package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Friend;
import com.melikesivrikaya.instagram.model.FriendState;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.FriendRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.FriendRequest;
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
    public List<FriendResponse> getAll() {
        return friendRepository.findAll().stream().map(FriendResponse::new).toList();
    }

    @Override
    public Optional<Friend> getById(Long id) {
        return friendRepository.findById(id);
    }

    @Override
    public FriendResponse create(FriendRequest request) {
        User user = userRepository.findById(request.getUserId()).get();
        User friend = userRepository.findById(request.getFriendId()).get();
        Friend usersFriend = new Friend(user,friend,FriendState.REQUEST);
        Friend friendsUser = new Friend(friend,user,FriendState.SENTED_REQUEST);
        try {
            friendRepository.save(friendsUser);
            friendRepository.save(usersFriend);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new FriendResponse(usersFriend);
    }
    //For accept friend request
    @Override
    public FriendResponse update(FriendRequest request) {
        Friend friend = friendRepository.findFriendByFriendIdAndUserId(request.getFriendId(), request.getUserId());
        Friend friend1 = friendRepository.findFriendByFriendIdAndUserId(request.getUserId(), request.getFriendId());
        friend1.setFriendState(FriendState.SUCCESS);
        friend.setFriendState(FriendState.SUCCESS);
        friendRepository.save(friend1);
        friendRepository.save(friend);
        return new FriendResponse(friend);
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

    @Override
    public List<FriendResponse> getAllByUserId(Long userId) {
        List<Friend> friendList = friendRepository.findByUserId(userId);
        return friendList.stream().map(FriendResponse::new).toList();
    }

    @Override
    public FriendResponse deleteFriends(FriendRequest request) {
        Friend friend = friendRepository.findFriendByFriendIdAndUserId(request.getFriendId(), request.getUserId());
        Friend friend1 = friendRepository.findFriendByFriendIdAndUserId(request.getUserId(), request.getFriendId());
        try {
            friendRepository.delete(friend);
            friendRepository.delete(friend1);
            return new FriendResponse(friend);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

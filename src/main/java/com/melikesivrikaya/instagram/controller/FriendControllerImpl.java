package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.FriendRequestState;
import com.melikesivrikaya.instagram.model.Friend;
import com.melikesivrikaya.instagram.request.FriendRequest;
import com.melikesivrikaya.instagram.response.FriendResponse;
import com.melikesivrikaya.instagram.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendControllerImpl implements FriendController {
    private final FriendService friendService;
    @GetMapping
    @Override
    public List<FriendResponse> getAll() {
        return friendService.getAll();
    }
    @GetMapping("{id}")
    @Override
    public Optional<Friend> getById(@PathVariable Long id) {
        return friendService.getById(id);
    }

    @DeleteMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return friendService.deleteById(id);
    }
    @GetMapping("userId/{id}")
    @Override
    public List<FriendResponse> getAllByUserId(@PathVariable Long id) {
        return friendService.getAllByUserId(id);
    }
    @PostMapping("state")
    @Override
    public FriendResponse friendHandleState(@RequestBody FriendRequest request) {
        if (request.getState() == FriendRequestState.SUCCESS){
            return friendService.update(request);
        }
        else if(request.getState() == FriendRequestState.REQUEST){
            return friendService.create(request);
        } else if (request.getState() == FriendRequestState.DELETE) {
            return friendService.deleteFriends(request);
        }
        return null;
    }
}

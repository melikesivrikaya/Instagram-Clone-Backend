package com.instagramclone.instagramcloneservicemain.controller;

import com.instagramclone.instagramcloneservicemain.dto.request.FriendRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.FriendResponse;
import com.instagramclone.instagramcloneservicemain.model.Friend;
import com.instagramclone.instagramcloneservicemain.model.enums.FriendRequestState;
import com.instagramclone.instagramcloneservicemain.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend")
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

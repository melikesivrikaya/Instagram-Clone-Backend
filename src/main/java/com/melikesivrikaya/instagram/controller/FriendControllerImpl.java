package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Friend;
import com.melikesivrikaya.instagram.request.CreateFriendRequest;
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
    public List<Friend> getAll() {
        return friendService.getAll();
    }
    @GetMapping("{id}")
    @Override
    public Optional<Friend> getById(@PathVariable Long id) {
        return friendService.getById(id);
    }
    @PostMapping
    @Override
    public FriendResponse create(@RequestBody CreateFriendRequest request) {
        return friendService.create(request);
    }
    @PutMapping
    @Override
    public Friend update(@RequestBody Friend friend) {
        return friendService.update(friend);
    }
    @DeleteMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return friendService.deleteById(id);
    }
}

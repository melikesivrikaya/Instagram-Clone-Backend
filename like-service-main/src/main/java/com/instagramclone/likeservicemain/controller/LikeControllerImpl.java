package com.instagramclone.likeservicemain.controller;

import com.instagramclone.likeservicemain.dto.response.LikeResponse;
import com.instagramclone.likeservicemain.dto.resquest.CreateLikeRequest;
import com.instagramclone.likeservicemain.model.Like;
import com.instagramclone.likeservicemain.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/likes")
public class LikeControllerImpl implements LikeController {
    private final LikeService likeService;
    @GetMapping
    @Override
    public List<LikeResponse> getAll() {
        return likeService.getAll();
    }
    @GetMapping("{id}")
    @Override
    public Optional<Like> getById(@PathVariable Long id) {
        return likeService.getById(id);
    }
    @PostMapping
    @Override
    public LikeResponse create(@RequestBody CreateLikeRequest like) {
        return likeService.create(like);
    }
    @PutMapping
    @Override
    public Like update(@RequestBody Like like) {
        return likeService.update(like);
    }
    @DeleteMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return likeService.deleteById(id);
    }
}

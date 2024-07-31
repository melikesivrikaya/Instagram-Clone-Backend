package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.request.CreateLikeRequest;
import com.melikesivrikaya.instagram.response.LikeResponse;
import com.melikesivrikaya.instagram.service.LikeService;
import com.melikesivrikaya.instagram.service.LikeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/like")
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

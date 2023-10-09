package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.request.CreatePostRequest;
import com.melikesivrikaya.instagram.request.UpdatePostRequest;
import com.melikesivrikaya.instagram.response.PostResponse;
import com.melikesivrikaya.instagram.service.PostService;
import com.melikesivrikaya.instagram.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostControllerImpl implements PostController {
    private final PostService postService;
    @GetMapping
    @Override
    public List<PostResponse> getAll() {
        return postService.getAll();
    }
    @GetMapping("{id}")
    @Override
    public Optional<Post> getById(@PathVariable Long id) {
        return postService.getById(id);
    }
    @PostMapping
    @Override
    public PostResponse create(@RequestBody CreatePostRequest post) {
        return postService.create(post);
    }
    @PutMapping
    @Override
    public PostResponse update(@RequestBody UpdatePostRequest post) {
        return postService.update(post);
    }
    @DeleteMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return postService.deleteById(id);
    }
}

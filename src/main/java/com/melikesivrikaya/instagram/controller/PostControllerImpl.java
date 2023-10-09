package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Post;
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
    private final PostServiceImpl postService;
    @GetMapping
    @Override
    public List<Post> getAll() {
        return postService.getAll();
    }
    @GetMapping("{id}")
    @Override
    public Optional<Post> getById(@PathVariable Long id) {
        return postService.getById(id);
    }
    @PostMapping
    @Override
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }
    @PutMapping
    @Override
    public Post update(@RequestBody Post post) {
        return postService.update(post);
    }
    @PostMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return postService.deleteById(id);
    }
}

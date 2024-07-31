package com.instagramclone.postservicemain.controller;

import com.instagramclone.postservicemain.dto.response.PostResponse;
import com.instagramclone.postservicemain.dto.resquest.CreatePostRequest;
import com.instagramclone.postservicemain.dto.resquest.UpdatePostRequest;
import com.instagramclone.postservicemain.model.Post;
import com.instagramclone.postservicemain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
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

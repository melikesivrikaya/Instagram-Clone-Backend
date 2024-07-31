package com.instagramclone.instagramcloneservicemain.controller;

import com.instagramclone.instagramcloneservicemain.dto.request.CreatePostRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.UpdatePostRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.PostResponse;
import com.instagramclone.instagramcloneservicemain.dto.response.PostResponseWithCommentsAndLikes;
import com.instagramclone.instagramcloneservicemain.model.Post;
import com.instagramclone.instagramcloneservicemain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
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
    @GetMapping("/userid/{userId}")
    @Override
    public List<PostResponseWithCommentsAndLikes> allPostsWithCommentAndLikesByUserId(@PathVariable Long userId) {
        return postService.allPostsWithCommentAndLikesByUserId(userId);
    }
    @GetMapping("/notfriend/{id}")
    @Override
    public List<PostResponseWithCommentsAndLikes> getAllPostsWitoutFriend(@PathVariable Long id){
        return postService.getAllPostsWitoutFriend(id);
    }

}

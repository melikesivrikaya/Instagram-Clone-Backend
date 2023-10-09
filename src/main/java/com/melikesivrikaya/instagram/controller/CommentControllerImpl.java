package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Comment;
import com.melikesivrikaya.instagram.request.CreateCommentRequest;
import com.melikesivrikaya.instagram.request.UpdateCommentRequest;
import com.melikesivrikaya.instagram.response.CommentResponse;
import com.melikesivrikaya.instagram.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentControllerImpl implements CommentController {
    private final CommentService commentService;
    @GetMapping
    @Override
    public List<CommentResponse> getAll() {
        return commentService.getAll();
    }
    @GetMapping("{id}")
    @Override
    public Optional<Comment> getById(@PathVariable Long id) {
        return commentService.getById(id);
    }
    @PostMapping
    @Override
    public CommentResponse create(@RequestBody CreateCommentRequest comment) {
        return commentService.create(comment);
    }
    @PutMapping
    @Override
    public CommentResponse update(@RequestBody UpdateCommentRequest comment) {
        return commentService.update(comment);
    }
    @DeleteMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return commentService.deleteById(id);
    }
}

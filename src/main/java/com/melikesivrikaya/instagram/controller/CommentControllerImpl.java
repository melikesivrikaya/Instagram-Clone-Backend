package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Comment;
import com.melikesivrikaya.instagram.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController {
    private final CommentService commentService;
    @GetMapping
    @Override
    public List<Comment> getAll() {
        return commentService.getAll();
    }
    @GetMapping("{id}")
    @Override
    public Optional<Comment> getById(@PathVariable Long id) {
        return commentService.getById(id);
    }
    @PostMapping
    @Override
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }
    @PutMapping
    @Override
    public Comment update(@RequestBody Comment comment) {
        return commentService.update(comment);
    }
    @PostMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return commentService.deleteById(id);
    }
}

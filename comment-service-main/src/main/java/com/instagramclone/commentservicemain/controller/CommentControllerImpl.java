package com.instagramclone.commentservicemain.controller;
import com.instagramclone.commentservicemain.dto.request.CreateCommentRequest;
import com.instagramclone.commentservicemain.dto.request.UpdateCommentRequest;
import com.instagramclone.commentservicemain.dto.response.CommentResponse;
import com.instagramclone.commentservicemain.model.Comment;
import com.instagramclone.commentservicemain.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
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

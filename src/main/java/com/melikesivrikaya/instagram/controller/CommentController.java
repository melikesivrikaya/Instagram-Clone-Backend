package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Comment;
import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.request.CreateCommentRequest;
import com.melikesivrikaya.instagram.request.UpdateCommentRequest;
import com.melikesivrikaya.instagram.response.CommentResponse;

import java.util.List;
import java.util.Optional;

public interface CommentController {
    List<CommentResponse> getAll();
    Optional<Comment> getById(Long id);
    CommentResponse create(CreateCommentRequest comment);
    CommentResponse update(UpdateCommentRequest comment);
    boolean deleteById(Long id);
}

package com.instagramclone.instagramcloneservicemain.controller;

import com.instagramclone.instagramcloneservicemain.dto.request.CreateCommentRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.UpdateCommentRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.CommentResponse;
import com.instagramclone.instagramcloneservicemain.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentController {
    List<CommentResponse> getAll();
    Optional<Comment> getById(Long id);
    CommentResponse create(CreateCommentRequest comment);
    CommentResponse update(UpdateCommentRequest comment);
    boolean deleteById(Long id);
}

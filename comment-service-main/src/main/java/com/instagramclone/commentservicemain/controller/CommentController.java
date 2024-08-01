package com.instagramclone.commentservicemain.controller;

import com.instagramclone.commentservicemain.dto.request.CreateCommentRequest;
import com.instagramclone.commentservicemain.dto.request.UpdateCommentRequest;
import com.instagramclone.commentservicemain.dto.response.CommentResponse;
import com.instagramclone.commentservicemain.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentController {
    List<CommentResponse> getAll();
    Optional<Comment> getById(Long id);
    CommentResponse create(CreateCommentRequest comment);
    CommentResponse update(UpdateCommentRequest comment);
    boolean deleteById(Long id);
}

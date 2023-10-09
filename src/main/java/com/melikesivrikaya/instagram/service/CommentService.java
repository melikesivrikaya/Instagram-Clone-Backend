package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Comment;
import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.request.CreateCommentRequest;
import com.melikesivrikaya.instagram.request.UpdateCommentRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getAll();
    Optional<Comment> getById(Long id);
    Comment create(CreateCommentRequest comment);
    Comment update(UpdateCommentRequest comment);
    boolean deleteById(Long id);
}

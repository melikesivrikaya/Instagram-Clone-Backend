package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Comment;
import com.melikesivrikaya.instagram.model.Like;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getAll();
    Optional<Comment> getById(Long id);
    Comment create(Comment comment);
    Comment update(Comment comment);
    boolean deleteById(Long id);
}

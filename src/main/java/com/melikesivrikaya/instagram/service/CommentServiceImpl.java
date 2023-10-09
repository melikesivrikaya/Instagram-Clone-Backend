package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Comment;
import com.melikesivrikaya.instagram.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            commentRepository.deleteById(id);
            return true;
        }
        catch (Exception e){

        }
        return false;
    }
}

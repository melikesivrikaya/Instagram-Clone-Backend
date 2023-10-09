package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Comment;
import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.CommentRepository;
import com.melikesivrikaya.instagram.repository.PostRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.CreateCommentRequest;
import com.melikesivrikaya.instagram.request.UpdateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment create(CreateCommentRequest comment) {
        User user = userRepository.findById(comment.getUserId()).get();
        Post post = postRepository.findById(comment.getPostId()).get();
        Comment newComment = new Comment();
        newComment.setUser(user);
        newComment.setPost(post);
        newComment.setText(comment.getText());
        return commentRepository.save(newComment);
    }

    @Override
    public Comment update(UpdateCommentRequest comment) {
        Comment currentComment = commentRepository.findById(comment.getId()).get();
        currentComment.setText(comment.getText());
        return commentRepository.save(currentComment);
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

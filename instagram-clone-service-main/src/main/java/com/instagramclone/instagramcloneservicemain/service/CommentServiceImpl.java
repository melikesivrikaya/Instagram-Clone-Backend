package com.instagramclone.instagramcloneservicemain.service;

import com.instagramclone.instagramcloneservicemain.dto.request.CreateCommentRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.UpdateCommentRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.CommentResponse;
import com.instagramclone.instagramcloneservicemain.model.Comment;
import com.instagramclone.instagramcloneservicemain.model.Post;
import com.instagramclone.instagramcloneservicemain.model.User;
import com.instagramclone.instagramcloneservicemain.repository.CommentRepository;
import com.instagramclone.instagramcloneservicemain.repository.PostRepository;
import com.instagramclone.instagramcloneservicemain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public List<CommentResponse> getAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(CommentResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public CommentResponse create(CreateCommentRequest comment) {
        User user = userRepository.findById(comment.getUserId()).get();
        Post post = postRepository.findById(comment.getPostId()).get();
        Comment newComment = new Comment();
        newComment.setUser(user);
        newComment.setPost(post);
        newComment.setText(comment.getText());
        try {
            commentRepository.save(newComment);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new CommentResponse(newComment);
    }

    @Override
    public CommentResponse update(UpdateCommentRequest comment) {
        Comment currentComment = commentRepository.findById(comment.getId()).get();
        currentComment.setText(comment.getText());
        try {
            commentRepository.save(currentComment);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new CommentResponse(currentComment);
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

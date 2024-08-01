package com.instagramclone.commentservicemain.service;
import com.instagramclone.commentservicemain.dto.request.CreateCommentRequest;
import com.instagramclone.commentservicemain.dto.request.UpdateCommentRequest;
import com.instagramclone.commentservicemain.dto.response.CommentResponse;
import com.instagramclone.commentservicemain.model.Comment;
import com.instagramclone.commentservicemain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
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
        Comment newComment = new Comment();
        newComment.setUserId(comment.getUserId());
        newComment.setPostId(comment.getPostId());
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

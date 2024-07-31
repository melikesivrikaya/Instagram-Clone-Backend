package com.instagramclone.instagramcloneservicemain.response;

import com.instagramclone.instagramcloneservicemain.model.Comment;
import lombok.Data;

@Data
public class CommentResponse {
    private Long id,userId,postId;
    private String text;
    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.text = comment.getText();
        this.postId = comment.getPost().getId();
        this.userId = comment.getUser().getId();
    }
}

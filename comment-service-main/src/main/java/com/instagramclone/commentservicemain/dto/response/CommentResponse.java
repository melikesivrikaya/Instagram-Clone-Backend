package com.instagramclone.commentservicemain.dto.response;

import com.instagramclone.commentservicemain.model.Comment;
import lombok.Data;

@Data
public class CommentResponse {
    private Long id,userId,postId;
    private String text;
    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.text = comment.getText();
        this.postId = comment.getPostId();
        this.userId = comment.getUserId();
    }
}

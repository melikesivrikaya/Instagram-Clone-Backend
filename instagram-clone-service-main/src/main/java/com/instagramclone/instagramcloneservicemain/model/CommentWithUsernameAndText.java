package com.instagramclone.instagramcloneservicemain.model;

import lombok.Data;

@Data
public class CommentWithUsernameAndText {
    private String text,userName;
    public CommentWithUsernameAndText(Comment comment){
        this.text = comment.getText();
        this.userName = comment.getUser().getFullName();
    }
}

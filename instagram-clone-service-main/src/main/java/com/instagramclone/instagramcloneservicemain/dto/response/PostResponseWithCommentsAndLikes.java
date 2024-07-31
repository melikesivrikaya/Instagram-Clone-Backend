package com.instagramclone.instagramcloneservicemain.dto.response;

import com.instagramclone.instagramcloneservicemain.model.Comment;
import com.instagramclone.instagramcloneservicemain.model.CommentWithUsernameAndText;
import com.instagramclone.instagramcloneservicemain.model.Like;
import com.instagramclone.instagramcloneservicemain.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponseWithCommentsAndLikes {
    private Long id;
    private String title,description,photourl;
    private List<String> likes;
    private List<CommentWithUsernameAndText> comments;

    public PostResponseWithCommentsAndLikes(Post post , List<Like> likes , List<Comment> comments){
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.photourl = post.getPhotourl();
        this.likes = likes.stream().map(like -> like.getUser().getFullName()).toList();
        this.comments = comments.stream().map(CommentWithUsernameAndText::new).toList();
    }


}

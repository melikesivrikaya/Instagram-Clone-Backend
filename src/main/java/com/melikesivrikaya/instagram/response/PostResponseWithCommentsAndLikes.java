package com.melikesivrikaya.instagram.response;

import com.melikesivrikaya.instagram.model.CommentWithUsernameAndText;
import com.melikesivrikaya.instagram.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponseWithCommentsAndLikes {
    private Long id;
    private String title,description,photourl;
    private List<String> likes;
    private List<CommentWithUsernameAndText> comments;
    public PostResponseWithCommentsAndLikes(Post post, List<CommentWithUsernameAndText> comments, List<String> likes){
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.photourl = post.getPhotourl();
        this.comments = comments;
        this.likes = likes;
    }
}

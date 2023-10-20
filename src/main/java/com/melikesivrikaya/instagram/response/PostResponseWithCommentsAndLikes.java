package com.melikesivrikaya.instagram.response;

import com.melikesivrikaya.instagram.model.Comment;
import com.melikesivrikaya.instagram.model.CommentWithUsernameAndText;
import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.model.Post;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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

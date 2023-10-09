package com.melikesivrikaya.instagram.response;

import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;
import lombok.Data;

@Data
public class PostResponse {
    private Long id,userId;
    private String title,description,photourl;
    public PostResponse(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.photourl = post.getPhotourl();
        this.userId = post.getUser().getId();
    }
}

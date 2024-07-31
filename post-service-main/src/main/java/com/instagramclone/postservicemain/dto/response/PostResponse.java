package com.instagramclone.postservicemain.dto.response;

import com.instagramclone.postservicemain.model.Post;
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
        this.userId = post.getUserId();
    }
}

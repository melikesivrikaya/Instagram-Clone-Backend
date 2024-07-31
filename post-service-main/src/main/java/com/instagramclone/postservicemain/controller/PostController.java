package com.instagramclone.postservicemain.controller;

import com.instagramclone.postservicemain.dto.response.PostResponse;
import com.instagramclone.postservicemain.dto.resquest.CreatePostRequest;
import com.instagramclone.postservicemain.dto.resquest.UpdatePostRequest;
import com.instagramclone.postservicemain.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostController {
    List<PostResponse> getAll();
    Optional<Post> getById(Long id);
    PostResponse create(CreatePostRequest post);
    PostResponse update(UpdatePostRequest post);
    boolean deleteById(Long id);


}

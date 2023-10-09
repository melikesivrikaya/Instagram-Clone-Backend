package com.melikesivrikaya.instagram.controller;

import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.request.CreatePostRequest;
import com.melikesivrikaya.instagram.request.UpdatePostRequest;
import com.melikesivrikaya.instagram.response.PostResponse;
import com.melikesivrikaya.instagram.response.PostResponseWithCommentsAndLikes;

import java.util.List;
import java.util.Optional;

public interface PostController {
    List<PostResponse> getAll();
    Optional<Post> getById(Long id);
    PostResponse create(CreatePostRequest post);
    PostResponse update(UpdatePostRequest post);
    boolean deleteById(Long id);

    List<PostResponseWithCommentsAndLikes> allPostsWithCommentAndLikesByUserId(Long userId);

}

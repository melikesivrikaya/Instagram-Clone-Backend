package com.instagramclone.instagramcloneservicemain.service;


import com.instagramclone.instagramcloneservicemain.dto.request.CreatePostRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.UpdatePostRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.PostResponse;
import com.instagramclone.instagramcloneservicemain.dto.response.PostResponseWithCommentsAndLikes;
import com.instagramclone.instagramcloneservicemain.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostResponse> getAll();
    Optional<Post> getById(Long id);
    PostResponse create(CreatePostRequest post);
    PostResponse update(UpdatePostRequest post);
    boolean deleteById(Long id);

    List<PostResponseWithCommentsAndLikes> allPostsWithCommentAndLikesByUserId(Long userId);
    List<PostResponseWithCommentsAndLikes> getAllPostsWitoutFriend(Long userId);
}

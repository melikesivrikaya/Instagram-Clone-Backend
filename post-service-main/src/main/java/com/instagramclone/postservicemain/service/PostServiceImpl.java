package com.instagramclone.postservicemain.service;
import com.instagramclone.postservicemain.dto.response.PostResponse;
import com.instagramclone.postservicemain.dto.resquest.CreatePostRequest;
import com.instagramclone.postservicemain.dto.resquest.UpdatePostRequest;
import com.instagramclone.postservicemain.model.Post;
import com.instagramclone.postservicemain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public List<PostResponse> getAll() {
        List<Post> posts =  postRepository.findAll();
        return posts.stream().map(PostResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public PostResponse create(CreatePostRequest post) {
        Post newPost = new Post();
        newPost.setPhotourl(post.getPhotourl());
        newPost.setTitle(post.getTitle());
        newPost.setDescription(post.getDescription());
        newPost.setUserId(post.getUserId());
        try {
            postRepository.save(newPost);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new PostResponse(newPost);
    }

    @Override
    public PostResponse update(UpdatePostRequest post) {
        Post currentPost = postRepository.findById(post.getId()).get();
        if(post.getTitle() != null){
            currentPost.setTitle(post.getTitle());
        }
        if (post.getDescription() != null){
            currentPost.setDescription(post.getDescription());
        }
        if(post.getPhotourl() != null){
            currentPost.setPhotourl(post.getPhotourl());
        }
        try {
            postRepository.save(currentPost);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new PostResponse(currentPost);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            postRepository.deleteById(id);
            return true;
        }catch (Exception e){

        }
        return false;
    }

}

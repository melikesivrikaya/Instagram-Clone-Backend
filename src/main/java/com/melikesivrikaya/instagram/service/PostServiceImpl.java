package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.PostRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.CreatePostRequest;
import com.melikesivrikaya.instagram.request.UpdatePostRequest;
import com.melikesivrikaya.instagram.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
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
        User user = userRepository.findById(post.getUserId()).get();
        newPost.setUser(user);
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

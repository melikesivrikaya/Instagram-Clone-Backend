package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.PostRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.CreatePostRequest;
import com.melikesivrikaya.instagram.request.UpdatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post create(CreatePostRequest post) {
        Post newPost = new Post();
        newPost.setPhotourl(post.getPhotourl());
        newPost.setTitle(post.getTitle());
        newPost.setDescription(post.getDescription());
        User user = userRepository.findById(post.getUserId()).get();
        newPost.setUser(user);
        return postRepository.save(newPost);
    }

    @Override
    public Post update(UpdatePostRequest post) {
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
        return postRepository.save(currentPost);
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

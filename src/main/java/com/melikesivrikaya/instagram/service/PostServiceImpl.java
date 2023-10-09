package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
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

package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.LikeRepository;
import com.melikesivrikaya.instagram.repository.PostRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.CreateLikeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    @Override
    public Optional<Like> getById(Long id) {
        return likeRepository.findById(id);
    }

    @Override
    public Like create(CreateLikeRequest like) {
        User user = userRepository.findById(like.getUserId()).get();
        Post post = postRepository.findById(like.getPostId()).get();
        Like newLike = new Like();
        newLike.setUser(user);
        newLike.setPost(post);
        return likeRepository.save(newLike);
    }

    @Override
    public Like update(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            likeRepository.deleteById(id);
            return true;
        }catch (Exception e){

        }
        return false;
    }
}

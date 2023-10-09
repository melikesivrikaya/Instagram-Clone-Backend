package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.model.Post;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.LikeRepository;
import com.melikesivrikaya.instagram.repository.PostRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.CreateLikeRequest;
import com.melikesivrikaya.instagram.response.LikeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public List<LikeResponse> getAll() {
        List<Like> likes = likeRepository.findAll();
        return likes.stream().map(LikeResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<Like> getById(Long id) {
        return likeRepository.findById(id);
    }

    @Override
    public LikeResponse create(CreateLikeRequest like) {
        User user = userRepository.findById(like.getUserId()).get();
        Post post = postRepository.findById(like.getPostId()).get();
        Like newLike = new Like();
        newLike.setUser(user);
        newLike.setPost(post);
        try {
            likeRepository.save(newLike);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new LikeResponse(newLike);
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

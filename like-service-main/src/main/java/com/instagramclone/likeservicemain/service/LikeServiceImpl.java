package com.instagramclone.likeservicemain.service;

import com.instagramclone.likeservicemain.dto.response.LikeResponse;
import com.instagramclone.likeservicemain.dto.resquest.CreateLikeRequest;
import com.instagramclone.likeservicemain.model.Like;
import com.instagramclone.likeservicemain.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
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
        Like newLike = new Like();
        newLike.setUserId(like.getUserId());
        newLike.setPostId(like.getPostId());
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

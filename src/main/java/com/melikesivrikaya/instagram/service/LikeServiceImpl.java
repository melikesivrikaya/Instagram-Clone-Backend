package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Like;
import com.melikesivrikaya.instagram.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    @Override
    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    @Override
    public Optional<Like> getById(Long id) {
        return likeRepository.findById(id);
    }

    @Override
    public Like create(Like like) {
        return likeRepository.save(like);
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

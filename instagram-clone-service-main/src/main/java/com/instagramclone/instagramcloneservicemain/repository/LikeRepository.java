package com.instagramclone.instagramcloneservicemain.repository;

import com.instagramclone.instagramcloneservicemain.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> findByPostId(Long postId);
}

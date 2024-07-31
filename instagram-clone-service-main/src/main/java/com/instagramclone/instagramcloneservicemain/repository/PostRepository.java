package com.instagramclone.instagramcloneservicemain.repository;

import com.instagramclone.instagramcloneservicemain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);
}

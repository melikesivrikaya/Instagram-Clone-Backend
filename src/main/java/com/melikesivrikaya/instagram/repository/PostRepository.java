package com.melikesivrikaya.instagram.repository;

import com.melikesivrikaya.instagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}

package com.melikesivrikaya.instagram.repository;

import com.melikesivrikaya.instagram.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}

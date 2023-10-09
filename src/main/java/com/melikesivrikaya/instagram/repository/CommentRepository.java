package com.melikesivrikaya.instagram.repository;

import com.melikesivrikaya.instagram.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}

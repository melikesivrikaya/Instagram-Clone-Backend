package com.melikesivrikaya.instagram.repository;

import com.melikesivrikaya.instagram.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findAllByUserId(Long userId);
}

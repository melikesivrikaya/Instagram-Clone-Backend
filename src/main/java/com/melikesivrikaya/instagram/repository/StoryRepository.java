package com.melikesivrikaya.instagram.repository;

import com.melikesivrikaya.instagram.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}

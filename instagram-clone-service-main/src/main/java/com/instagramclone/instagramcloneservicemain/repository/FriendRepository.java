package com.instagramclone.instagramcloneservicemain.repository;

import com.instagramclone.instagramcloneservicemain.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend,Long> {
    List<Friend> findByUserId(Long userId);
    Friend findFriendByFriendIdAndUserId(Long friendId, Long userId);
}

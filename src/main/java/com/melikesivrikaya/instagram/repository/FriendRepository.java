package com.melikesivrikaya.instagram.repository;

import com.melikesivrikaya.instagram.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend,Long> {
}

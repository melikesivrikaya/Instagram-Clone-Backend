package com.melikesivrikaya.instagram.repository;

import com.melikesivrikaya.instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

package com.melikesivrikaya.instagram.repository;

import com.melikesivrikaya.instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByEmail(String email);
}

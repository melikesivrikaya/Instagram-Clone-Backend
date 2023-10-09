package com.melikesivrikaya.instagram.response;

import com.melikesivrikaya.instagram.model.Role;
import com.melikesivrikaya.instagram.model.User;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String firstname,lastname,fullname,username,email,phone;
    public UserResponse(User user){
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.fullname = user.getFullname();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }
}

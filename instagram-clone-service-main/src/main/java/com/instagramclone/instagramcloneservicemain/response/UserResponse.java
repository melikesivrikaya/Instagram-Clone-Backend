package com.instagramclone.instagramcloneservicemain.response;

import com.instagramclone.instagramcloneservicemain.model.User;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String firstname,lastname,fullName,username,email,phone,profilePhoto;
    public UserResponse(User user){
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.fullName = user.getFullName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.profilePhoto = user.getProfilePhoto();
    }
}

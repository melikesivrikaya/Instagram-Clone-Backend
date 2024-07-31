package com.instagramclone.instagramcloneservicemain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long friendId;
    private String firstname,lastname,fullname,username;
    private FriendState friendState;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    public Friend(User user , User friend , FriendState state){
        this.friendId = friend.getId();
        this.firstname = friend.getFirstname();
        this.lastname = friend.getLastname();
        this.fullname = friend.getFullName();
        this.username = friend.getUsername();
        this.user = user;
        this.friendState = state;

    }
}

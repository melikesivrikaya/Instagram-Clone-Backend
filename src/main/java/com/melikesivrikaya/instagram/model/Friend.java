package com.melikesivrikaya.instagram.model;

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
    private String firstname,lastname,fullname,username;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    public Friend(User user , User friend){
        this.firstname = friend.getFirstname();
        this.lastname = friend.getLastname();
        this.fullname = friend.getFullname();
        this.username = friend.getUsername();
        this.user = user;
    }
}

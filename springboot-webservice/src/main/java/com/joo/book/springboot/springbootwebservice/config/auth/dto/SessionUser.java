package com.joo.book.springboot.springbootwebservice.config.auth.dto;

import com.joo.book.springboot.springbootwebservice.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

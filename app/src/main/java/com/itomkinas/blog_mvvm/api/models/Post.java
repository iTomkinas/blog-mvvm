package com.itomkinas.blog_mvvm.api.models;

public class Post {

    private Long id;
    private Long userId;
    private String title;
    private String body;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}

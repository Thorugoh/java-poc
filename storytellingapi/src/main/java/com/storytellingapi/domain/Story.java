package com.storytellingapi.domain;

public class Story {
    public String id;
    public String title;
    public String content;

    public Story(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
}

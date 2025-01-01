package com.test.rippling.models;

public class Question {
    public String questionId;
    public String title, content;
    public User user;

    public Question(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public String toString() {
        return this.questionId;
    }
}

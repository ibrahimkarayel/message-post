package com.jowl.msg.post.domain;

import java.time.LocalDateTime;
import java.util.List;

public class PostBuilder {
    private User author;
    private String subject;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime changeDate;
    private List<Comment> comments;

    public PostBuilder setAuthor(User author) {
        this.author = author;
        return this;
    }

    public PostBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public PostBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public PostBuilder setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public PostBuilder setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
        return this;
    }

    public PostBuilder setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Post createPost() {
        return new Post(author, subject, content, creationDate, changeDate, comments);
    }
}

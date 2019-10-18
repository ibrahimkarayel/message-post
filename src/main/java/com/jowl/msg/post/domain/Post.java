package com.jowl.msg.post.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "post")
public class Post implements Comparable<Post> {
    @Id
    private String postId;
    @Valid
    @NotNull
    private User author;
    private String subject;
    @NotBlank(message = "Expected not-blank content.")
    private String content;
    private LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime changeDate;
    private List<Comment> comments=new ArrayList<>();

    protected Post() {
    }

    public Post(User author, String subject, String content, LocalDateTime creationDate, LocalDateTime changeDate, List<Comment> comments) {
        this.author = author;
        this.subject = subject;
        this.content = content;
        this.creationDate = creationDate;
        this.changeDate = changeDate;
        this.comments = comments;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) &&
                Objects.equals(author, post.author) &&
                Objects.equals(subject, post.subject) &&
                Objects.equals(content, post.content) &&
                Objects.equals(creationDate, post.creationDate) &&
                Objects.equals(changeDate, post.changeDate) &&
                Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, author, subject, content, creationDate, changeDate, comments);
    }

    @Override
    public int compareTo(Post o) {
        if (getChangeDate() == null || o.getChangeDate() == null) {
            return 0;
        }
        return o.getChangeDate().compareTo(getChangeDate());
    }
}

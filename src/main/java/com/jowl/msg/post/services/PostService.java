package com.jowl.msg.post.services;

import com.jowl.msg.post.domain.Comment;
import com.jowl.msg.post.domain.Post;

import java.util.List;

public interface PostService {

    Post save(Post post);

    Post addComment(String id, Comment comment);

    void delete(Post post);

    boolean delete(String id);

    List<Post> findByAuthor(String email);

    List<Post> finAll();

}

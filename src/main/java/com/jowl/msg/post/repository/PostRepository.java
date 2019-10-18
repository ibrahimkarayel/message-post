package com.jowl.msg.post.repository;

import com.jowl.msg.post.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByAuthor_Email(String email);

}

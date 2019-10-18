package com.jowl.msg.post.controllers;


import com.jowl.msg.post.domain.Comment;
import com.jowl.msg.post.domain.Post;
import com.jowl.msg.post.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @GetMapping("/user/{email}")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable("email") String email) {
        List<Post> posts = postService.findByAuthor(email);
        if (posts != null) {
            return ResponseEntity.ok(posts);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> posts = postService.finAll();
        if (posts != null) {
            return ResponseEntity.ok(posts);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/post")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post created = postService.save(post);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/post/comment/{postId}")
    public ResponseEntity<Post> savePostComment(@PathVariable("postId") String postId, @RequestBody Comment comment) {
        Post created = postService.addComment(postId, comment);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") String id, @RequestBody Post post) {
        if (id == null) {
            return ResponseEntity.noContent().build();
        }
        Post updated = postService.save(post);
        if (updated != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity deletePost(@PathVariable("id") String id) {
        if (postService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }


}

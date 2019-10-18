package com.jowl.msg.post.services;

import com.jowl.msg.post.domain.Comment;
import com.jowl.msg.post.domain.Post;
import com.jowl.msg.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post addComment(String id, Comment comment) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.getComments().add(comment);
            postRepository.save(post);
            return post;
        }
        return null;
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public boolean delete(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            postRepository.delete(post.get());
            return true;
        }
        return false;

    }

    @Override
    public List<Post> findByAuthor(String email) {
        return postRepository.findByAuthor_Email(email);
    }

    @Override
    public List<Post> finAll() {
        return postRepository.findAll();
    }
}

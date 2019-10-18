package com.jowl.msg.post.bootstrap;


import com.jowl.msg.post.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
@Profile("dev")
public class AppUserLoader implements CommandLineRunner {

    private Logger LOGGER = LoggerFactory.getLogger(AppUserLoader.class);
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) {

  /*      User user = new User("SAJMpcS6bnc7Y1H2OfW8MekFwC99", "ibrahim KARAYEL", "i.karayel@gmai.com",
                "https://lh4.googleusercontent.com/-suO-WRlOnkI/AAAAAAAAAAI/AAAAAAAAAAc/YMdCxhHa4v8/photo.jpg");
        List<Comment> commentList = List.of(new Comment(user, "first comment"), new Comment(user, "second comment"));

        Post post = new PostBuilder().setAuthor(user).setComments(commentList).setContent("First Post").setSubject("Show").createPost();
        postRepository.save(post);*/
    }
}

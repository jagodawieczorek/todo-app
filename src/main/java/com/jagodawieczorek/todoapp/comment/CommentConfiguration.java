package com.jagodawieczorek.todoapp.comment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentConfiguration {
    @Bean
    public CommentService commentService(CommentRepository commentRepository) {
        return new CommentServiceImpl(commentRepository);
    }
}

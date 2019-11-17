package com.jagodawieczorek.todoapp.comment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    public final CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
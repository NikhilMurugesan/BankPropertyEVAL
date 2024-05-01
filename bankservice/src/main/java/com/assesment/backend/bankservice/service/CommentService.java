package com.assesment.backend.bankservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import com.assesment.backend.bankservice.model.Comment;
import com.assesment.backend.bankservice.repository.CommentRepository;

@Service
public class CommentService {
    // Comment service methods
     private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment) {
        // You may add additional validation logic here before saving the comment
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with id: " + id));
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        Comment existingComment = getCommentById(id);
        // Update the fields of existingComment with the fields of updatedComment
        // Handle other logic as needed
        return commentRepository.save(existingComment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}

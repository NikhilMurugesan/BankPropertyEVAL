package com.assesment.backend.bankservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.backend.bankservice.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Additional methods if needed
}


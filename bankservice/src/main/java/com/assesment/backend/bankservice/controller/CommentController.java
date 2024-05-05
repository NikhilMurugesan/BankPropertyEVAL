package com.assesment.backend.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assesment.backend.bankservice.model.FacilityDetail;
import com.assesment.backend.bankservice.model.Comment;
import com.assesment.backend.bankservice.service.CommentService;
import com.assesment.backend.bankservice.service.FacilityDetailService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    // Comment controller methods
    @Autowired
    private CommentService commentService;

    @Autowired
    private FacilityDetailService facilityDetailService;
    private FacilityDetail facilityDetail;
    
    @PostMapping("/{facilityid}")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment,@PathVariable("facilityid") Long facilityID) {
        facilityDetail = facilityDetailService.getFacilityById(facilityID);
        comment.setFacility(facilityDetail);
        Comment savedComment = commentService.createComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        Iterable<Comment> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
   
}
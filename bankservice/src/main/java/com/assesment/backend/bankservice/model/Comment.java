package com.assesment.backend.bankservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private LocalDateTime date;
    private String user;
    private String comment;
    // Getters and setters
    @OneToOne
    @JoinColumn(name = "facility_id")
    private FacilityDetail facility;

    public Comment(Long commentId, LocalDateTime date, String user, String comment, FacilityDetail facility) {
        this.commentId = commentId;
        this.date = date;
        this.user = user;
        this.comment = comment;
        this.facility = facility;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public Comment() {
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Long getCommentId() {
        return commentId;
    }
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    public FacilityDetail getFacility() {
        return facility;
    }
    public void setFacility(FacilityDetail facility) {
        this.facility = facility;
    }
}
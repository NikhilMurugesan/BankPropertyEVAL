package com.assesment.backend.bankservice.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UploadedDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private String documentType;
    private String fileName;
    private byte[] content;
    
    public String getDocumentType() {
        return documentType;
    }
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public UploadedDocument() {
    }
    public UploadedDocument(Long id, String documentType, String fileName) {
        this.documentId = id;
        this.documentType = documentType;
        this.fileName = fileName;
    }
     public void setContent(MultipartFile file) {
        try {
            this.content = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("Error setting content: " + e.getMessage());
        }
    }
    public byte[] getContent() {
            return this.content;
        }
    public Long getDocumentId() {
        return documentId;
    }
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }
    public void setContent(byte[] content) {
        this.content = content;
    }

    // Getters, setters, and constructors
}

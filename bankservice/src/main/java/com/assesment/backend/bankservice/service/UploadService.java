package com.assesment.backend.bankservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.assesment.backend.bankservice.model.UploadedDocument;
import com.assesment.backend.bankservice.repository.UploadedDocumentRepository;

@Service
public class UploadService {
    private final UploadedDocumentRepository repository;
    

    @Autowired
    public UploadService(UploadedDocumentRepository repository) {
        this.repository = repository;
    }

    public UploadedDocument uploadDocument(String documentType, MultipartFile file) {
        UploadedDocument document = new UploadedDocument();
        document.setDocumentType(documentType);
        document.setFileName(file.getOriginalFilename());

        try {
            document.setContent(file);
        } catch (Exception e) {
            throw new RuntimeException("Error uploading file: " + e.getMessage());
        }

        return repository.save(document);
    }
    public UploadedDocument getDocumentById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }
    
   
}
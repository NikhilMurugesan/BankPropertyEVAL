package com.assesment.backend.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.assesment.backend.bankservice.model.UploadedDocument;
import com.assesment.backend.bankservice.repository.UploadedDocumentRepository;
import com.assesment.backend.bankservice.service.UploadService;

@RestController
@RequestMapping("/api/upload")
public class UploadController {
    private UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping
    public ResponseEntity<UploadedDocument> uploadDocument(
            @RequestParam("documentType") String documentType,
            @RequestParam("document") MultipartFile file) {
        UploadedDocument uploadedDocument = new UploadedDocument();
        uploadedDocument.setDocumentType(documentType);
        uploadedDocument.setFileName(file.getOriginalFilename());
        uploadedDocument.setContent(file);

        UploadedDocument savedDocument = uploadService.uploadDocument(documentType,file);

        return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        UploadedDocument document = uploadService.getDocumentById(id);

        if (document != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + document.getFileName());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(document.getContent());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   
}
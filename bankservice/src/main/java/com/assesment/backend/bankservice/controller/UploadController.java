package com.assesment.backend.bankservice.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assesment.backend.bankservice.model.UploadedDocument;
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
    public ResponseEntity<Map<String, String>> uploadDocument(@RequestPart("file") MultipartFile file)throws IOException  {

        //UploadedDocument savedDocument = uploadService.uploadDocument(documentType,file);

       // return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
         try {
      
      File f = new ClassPathResource("").getFile();
      final Path path = Paths.get(f.getAbsolutePath() + File.separator + "static" + File.separator + "image");

      if (!Files.exists(path)) {
        Files.createDirectories(path);
      }

      Path filePath = path.resolve(file.getOriginalFilename());
      Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

      String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
          .path("/image/")
          .path(file.getOriginalFilename())
          .toUriString();

      var result = Map.of(
          "filename", file.getOriginalFilename(),
          "fileUri", fileUri
      );
      
      return new ResponseEntity<>(result,HttpStatus.OK);

    } catch (IOException e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
   
}
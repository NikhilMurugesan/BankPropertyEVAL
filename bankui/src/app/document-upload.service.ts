import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DocumentUploadService {

  constructor(private http: HttpClient) { }

  uploadDocument(uploadType: string, file: File) {
    const formData = new FormData();
    formData.append('documentType', uploadType);
    formData.append('document', file);

    return this.http.post('http://localhost:9090', formData);
  }
}
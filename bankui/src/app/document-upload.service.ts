import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UploadDocument } from './uploaddocument.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocumentUploadService {

  constructor(private http: HttpClient) { }
  private baseUrl = "http://localhost:9090/api/upload"


  upload(file: File): Observable<UploadDocument> {

    const formData: FormData = new FormData();
    formData.append('file', file);
    return this.http.post<UploadDocument>(`${this.baseUrl}`, formData);
  }
}
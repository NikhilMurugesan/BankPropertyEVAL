import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comments } from './comments.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private apiUrl = 'http://localhost:9090/api/comments'; // Adjust the URL according to your backend API

  constructor(private http: HttpClient) { }

  // Method to add a comment for a specific facility
  addComment(comment: Comments, facilityId: number): Observable<Comments> {
    return this.http.post<Comments>(`${this.apiUrl}/${facilityId}`, comment);
  }

  // Method to get a comment by its ID
  getCommentById(commentId: number): Observable<Comments> {
    return this.http.get<Comments>(`${this.apiUrl}/${commentId}`);
  }

  // Method to get all comments
  getAllComments(): Observable<Comments[]> {
    return this.http.get<Comments[]>(this.apiUrl);
  }
}

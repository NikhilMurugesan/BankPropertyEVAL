import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Borrower } from './borrower.model';

@Injectable({
  providedIn: 'root'
})
export class BorrowerService {
  private apiUrl = 'http://localhost:9090/borrowers'; // Adjust the URL according to your backend API

  constructor(private http: HttpClient) { }

  // Method to add a main borrower
  addMainBorrower(mainBorrower: Borrower): Observable<Borrower> {
    return this.http.post<Borrower>(`${this.apiUrl}/main`, mainBorrower);
  }

  // Method to get all main borrowers
  getAllMainBorrowers(): Observable<Borrower[]> {
    return this.http.get<Borrower[]>(`${this.apiUrl}/main`);
  }

  // Method to add a joint borrower
  addJointBorrower(jointBorrower: Borrower): Observable<Borrower> {
    return this.http.post<Borrower>(`${this.apiUrl}/joint`, jointBorrower);
  }

  // Method to get all joint borrowers
  getAllJointBorrowers(): Observable<Borrower[]> {
    return this.http.get<Borrower[]>(`${this.apiUrl}/joint`);
  }

  // Method to delete a joint borrower by index
  deleteJointBorrower(index: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/joint/${index}`);
  }
}

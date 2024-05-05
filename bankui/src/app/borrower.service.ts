import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Borrower } from './borrower.model';
import { JointBorrower } from './jointborrower.model';
import { JointBorrowers } from './jointborrowers.model';

@Injectable({
  providedIn: 'root'
})
export class BorrowerService {
  private apiUrl = 'http://localhost:9090/borrowers'; // Adjust the URL according to your backend API

  constructor(private http: HttpClient) { }

  // Method to add a main borrower
  addMainBorrower(mainBorrower: Borrower,facilityId:number): Observable<Borrower> {
    return this.http.post<Borrower>(`${this.apiUrl}/main/${facilityId}`, mainBorrower);
  }

  // Method to get all main borrowers
  getAllMainBorrowers(): Observable<Borrower[]> {
    return this.http.get<Borrower[]>(`${this.apiUrl}/main`);
  }

  // Method to add a joint borrower
  addJointBorrower(jointBorrower: JointBorrower): Observable<JointBorrower> {
    return this.http.post<JointBorrower>(`${this.apiUrl}/joint`, jointBorrower);
  }
  addJointBorrowers(jointBorrower: Borrower[]): Observable<JointBorrowers> {
    return this.http.post<JointBorrowers>(`${this.apiUrl}/joint`, jointBorrower);
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

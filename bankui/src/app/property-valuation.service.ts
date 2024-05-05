import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { FacilityDetail } from './FacilityDetail.model';

@Injectable({
  providedIn: 'root'
})
export class PropertyValuationService {

  private baseUrl = 'http://localhost:9090/api'; 

  constructor(private http: HttpClient) { }

  getTypeOfFacility(): Observable<any> {
    return this.http.get(`${this.baseUrl}/type-of-facility`);
  }

  getCategories(): Observable<any> {
    return this.http.get(`${this.baseUrl}/categories`);
  }

  getPurposesOfValuation(): Observable<any> {
    return this.http.get(`${this.baseUrl}/purposes-of-valuation`);
  }

  getCurrencies(): Observable<any> {
    return this.http.get(`${this.baseUrl}/currencies`);
  }// Update with your actual backend API URL

  getPropertyValuationData(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/data`)
      .pipe(
        catchError(this.handleError)
      );
  }
  getPropertyDetailsByFOSReference(fosReference: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/property/details/${fosReference}`);
  }

  createPropertyValuationData(propertyValuationData: FacilityDetail): Observable<any> {
    return this.http.post(`${this.baseUrl}/facilities`, propertyValuationData)
     .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: any) {
    console.error('Error fetching property valuation data:', error);
    return throwError(error);
  }
}

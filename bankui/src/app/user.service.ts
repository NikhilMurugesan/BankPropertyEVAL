import { Injectable } from '@angular/core';
import { User } from './user.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  
  private baseUrl = 'http://localhost:9090/api'; // Update with your backend base URL

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, { username, password });
  }
  public LoginUserFromRemote(user:User): Observable<User>{

    return this.http.post<User>(`${this.baseUrl}/login`,user);
  }
}

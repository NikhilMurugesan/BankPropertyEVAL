import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  msg = '';

  constructor(private router: Router, private service: UserService) { }

  loginform = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  get username() {
    const control = this.loginform.get('username');
    if (!control) {
      throw new Error('Control is null');
    }
    return control;
  }
  
  get password() {
    const control = this.loginform.get('password');
    if (!control) {
      throw new Error('Control is null');
    }
    return control;
  }
  
  user : User=new User();
  loginUser() {
    const usernameControl = this.loginform.get('username');
    const passwordControl = this.loginform.get('password');
  
    if (usernameControl && passwordControl) {
      const username = usernameControl.value;
      const password = passwordControl.value;
    
      
    this.service.login(username as string, password as string).subscribe({
      next: (data) => {
        // Navigate to the dashboard upon successful login
        this.user = data;
        this.router.navigate(['/p', this.user]);
      },
      error: (error) => {
        // Handle login failure, display error message
        console.log('Exception occurred');
        this.msg = 'Invalid credentials. Please enter valid username and password.';
      },
      complete: () => {
        // Optional: Handle completion of the observable (if needed)
      }
    });
  }else {
    console.error('Form controls are null or undefined');
  }
}

  onSubmit() {
    this.loginUser();
  }
}

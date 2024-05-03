import { Component, OnInit } from '@angular/core';
import { DocumentUploadService } from '../document-upload.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Borrower } from '../borrower.model';
import { Comments } from '../comments.model';
import { User } from '../user.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BorrowerService } from '../borrower.service';
@Component({
  selector: 'app-borrower',
  templateUrl: './borrower.component.html',
  styleUrls: ['./borrower.component.css']
})
export class BorrowerComponent implements OnInit {

  mainBorrower: Borrower = new Borrower();
  jointBorrowers: Borrower[] = [];
  comments: Comments[] = [];
  uploadType: any;
  uploadedDocuments: any[] = [];
  newComment: string = '';
  user : User = new User();
  mainBorrowerForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private borrowerService: BorrowerService,private documentUploadService :DocumentUploadService,private route: ActivatedRoute,private router : Router) {
    this.mainBorrowerForm = this.formBuilder.group({
      customerNumber: ['', Validators.required],
      customerName: ['', Validators.required],
      contactNumber: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      address: ['', Validators.required]
    });
   }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log('Route Parameters:Brower', params);
      this.user.username = params['username'];
      console.log('Route Parameters:Brower', this.user.username);
    });
  }
  addMainBorrower()
  {
    if (this.mainBorrowerForm.invalid) {
      return;
    }

    const mainBorrower: Borrower = {
      customerNumber: this.mainBorrowerForm.value.customerNumber,
      customerName: this.mainBorrowerForm.value.customerName,
      contactNumber: this.mainBorrowerForm.value.contactNumber,
      email: this.mainBorrowerForm.value.email,
      address: this.mainBorrowerForm.value.address
    };

    this.borrowerService.addMainBorrower(mainBorrower).subscribe({
      next: (response) => {
        console.log('Main borrower added successfully:', response);
        this.mainBorrowerForm.reset();
      },
      error: (error) => {
        console.error('Error adding main borrower:', error);
      }
    });
  }
  addJointBorrower(): void {
    this.jointBorrowers.push(new Borrower());
  }

  removeJointBorrower(index: number): void {
    this.jointBorrowers.splice(index, 1);
  }

  addComment(): void {
    // Add a new comment with current date and user information
    const currentDate = new Date();
    
    this.route.params.subscribe({
      next: (params) => {
        this.mainBorrower.customerNumber = params['customerNumber'];
        this.mainBorrower.customerName = params['customerName'];
        this.mainBorrower.contactNumber = params['contactNumber'];
        this.mainBorrower.email = params['email'];
        this.mainBorrower.address = params['address'];
      },
      error: (error) => {
        console.log(error);
      }
    });
    const newComment: Comments = {
      date: currentDate.toISOString(),
      // You can replace this with actual user information
      user: this.user.username,
      comment: this.newComment
    };
    this.comments.push(newComment);
    this.newComment = ''; // Clear the input field after adding the comment
  }

  uploadDocument(): void {
    const fileInput = document.getElementById('fileInput') as HTMLInputElement;

    if (fileInput.files && fileInput.files.length > 0) {
      const file = fileInput.files[0];

      // Prepare data to send to server (replace with your API endpoint)
      const formData = new FormData();
      formData.append('documentType', this.uploadType);
      formData.append('document', file);


      // Send the file to the server using HttpClient
      this.documentUploadService.uploadDocument(this.uploadType,file).subscribe({
        
        next: (data) => {
        
          // Handle success response
          console.log('Property valuation submitted successfully:', data);
          // Navigate to browser or perform other actions upon success
          this.router.navigate(['/b']); // Replace '/browser' with your desired route
        },
        error:  (error) => {
          // Handle error response
          console.error('Error submitting property valuation:', error);
          // You can display an error message or perform other error handling here
        }}
      );
    }
  }
}
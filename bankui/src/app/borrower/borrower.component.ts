import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router,NavigationExtras } from '@angular/router';
import { Borrower } from '../borrower.model';
import { BorrowerService } from '../borrower.service';
import { JointBorrower } from '../jointborrower.model';
import { User } from '../user.model';
import { FacilityDetail } from '../FacilityDetail.model';
import { JointBorrowers } from '../jointborrowers.model';
import { DocumentUploadService } from '../document-upload.service';
@Component({
  selector: 'app-borrower',
  templateUrl: './borrower.component.html',
  styleUrls: ['./borrower.component.css']
})
export class BorrowerComponent implements OnInit {

  mainBorrower: Borrower = new Borrower();
  jointBorrowers: JointBorrower[] = [];
  jointBorrower: JointBorrower = new JointBorrower();
  user: User = new User();
  facility: FacilityDetail=new FacilityDetail();
  ID: number|undefined;
  jointborrowerID: number|undefined;
  mainBorrowerForm: FormGroup;
  jointBorrowerForm: FormGroup;
  mainBorrowerAdded: boolean = false;
  successMessage: any;
  successMessage1: any;
  uploadType: any;
  uploadedDocuments: any[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private borrowerService: BorrowerService,
    private route: ActivatedRoute,
    private router: Router,
    private documentUploadService :DocumentUploadService,
  ) {
    this.mainBorrowerForm = this.formBuilder.group({
      customerNumber: ['', Validators.required],
      customerName: ['', Validators.required],
      contactNumber: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      address: ['', Validators.required]
    });

    this.jointBorrowerForm = this.formBuilder.group({
      customerNumber: ['', Validators.required],
      customerName: ['', Validators.required],
      contactNumber: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      address: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    
    this.route.params.subscribe(params => {
      this.facility.id=params['facilityId'];
      this.ID=this.facility.id;
    });
  }
  uploadDocument(): void {
    const fileInput = document.getElementById('fileInput') as HTMLInputElement;

    if (fileInput.files && fileInput.files.length > 0) {
      const file = fileInput.files[0];
      const formData = new FormData();
      formData.append('documentType', this.uploadType);
      formData.append('document', file);
      this.documentUploadService.upload(file).subscribe({
        
        next: (data) => {
          console.log('Document submitted successfully:', data);
        },
        error:  (error) => {
          console.error('Error submitting property valuation:', error);
        }}
      );
    }
  }
    addMainBorrower(): void {
    if (this.mainBorrowerForm.invalid) {
      return;
    }
    const mainBorrower: Borrower = {
      customerNumber: this.mainBorrowerForm.value.customerNumber,
      customerName: this.mainBorrowerForm.value.customerName,
      contactNumber: this.mainBorrowerForm.value.contactNumber,
      email: this.mainBorrowerForm.value.email,
      address: this.mainBorrowerForm.value.address,
      id: 0
    };
    console.log(mainBorrower);
    if(this.ID!== undefined) {
    this.borrowerService.addMainBorrower(mainBorrower,this.ID).subscribe({
      next: (response) => {
        console.log('Main borrower added successfully:', response);
        this.successMessage = 'Main borrower added successfully';
        this.mainBorrowerAdded = true;
      },
      error: (error) => {
        console.error('Error adding main borrower:', error);
      }
    });
    }else {
      // Handle the case where the value is undefined
      console.error("this.facility.id is undefined");
  }
  }
  goToAddComment(): void {
    const navigationExtras : NavigationExtras = {
      state:{
        user:this.user,
        facility:this.facility
      }
    };
    this.router.navigate(['/comment',this.ID]);
  }
  addJointBorrowers(): void {
    if (this.jointBorrowerForm.invalid) {
      return;
    }
    

    const jointBorrower: JointBorrower = {
      customerNumber: this.jointBorrowerForm.value.customerNumber,
      customerName: this.jointBorrowerForm.value.customerName,
      contactNumber: this.jointBorrowerForm.value.contactNumber,
      email: this.jointBorrowerForm.value.email,
      address: this.jointBorrowerForm.value.address,
      jointBorrowerId: this.jointBorrowerForm.value.id
    };
    
    this.borrowerService.addJointBorrower(jointBorrower).subscribe({
      next: (response) => {
        console.log('Joint borrowers added successfully:', response);
        this.successMessage1 = 'Joint borrower added successfully';
        this.jointBorrowerForm.reset();
        this.jointBorrowers.push(response);
      },
      error: (error) => {
        console.error('Error adding joint borrowers:', error);
      }
    });
  }

  removeJointBorrower(index: number,borrower:JointBorrower): void {
    if( borrower.jointBorrowerId!==undefined){
    this.borrowerService.deleteJointBorrower( borrower.jointBorrowerId).subscribe({
      next: (response) => {
        console.log('Joint borrowers removed successfully:', response);
      },
      error: (error) => {
        console.error('Error removing joint borrowers:', error);
      }
    });
  }
  this.jointBorrowers.splice(index, 1);
  }
  
}

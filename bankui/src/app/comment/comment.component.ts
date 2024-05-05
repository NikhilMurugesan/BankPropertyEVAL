import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router, response } from 'express';
import { BorrowerService } from '../borrower.service';
import { Comments } from '../comments.model';
import { DocumentUploadService } from '../document-upload.service';
import { User } from '../user.model';
import { FacilityDetail } from '../FacilityDetail.model';
import { CommentService } from '../comment.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrl: './comment.component.css'
})
export class CommentComponent {
  comments: Comments[] = [];
  uploadType: any;
  uploadedDocuments: any[] = [];
  newComment: string = '';
  user :string = '';
  facility: FacilityDetail=new FacilityDetail();
  constructor(private formBuilder: FormBuilder,private commentsService: CommentService,private documentUploadService :DocumentUploadService,private route: ActivatedRoute,private router : Router) {
  }
  addComment(): void {
    // Add a new comment with current date and user information
    const currentDate = new Date();
    const newComment: Comments = {
      date: currentDate.toISOString(),
      user: this.user,
      comment: this.newComment
    };
    this.comments.push(newComment);
    if(this.facility.id!==undefined){
    this.commentsService.addComment(newComment,this.facility.id).subscribe({
      next: (response) => {
        console.log('Property details retrieved successfully:', response);
      },
      error: (error) => {
        console.error('Error retrieving property details:', error);
      }
    });
  }
    this.newComment = ''; 
  }
  ngOnInit(): void {
    
    this.route.params.subscribe(params => {
      this.facility.id=params['facilityId'];
      console.log('Route Parameters:', params,this.facility.id);
    });
  }
}

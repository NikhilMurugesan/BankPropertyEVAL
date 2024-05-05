import { Component, OnInit } from '@angular/core';
import { PropertyValuationService } from '../property-valuation.service';
import { ActivatedRoute, NavigationExtras, Router } from '@angular/router';
import { FacilityDetail } from '../FacilityDetail.model';
@Component({
  selector: 'app-property-valuation',
  templateUrl: './property-valuation.component.html',
  styleUrl: './property-valuation.component.css'
})
export class PropertyValuationComponent implements OnInit{
navigateToNewProperty() {
throw new Error('Method not implemented.');
}

  
  fosReference: string | undefined;
  typeOfEvaluation: string | undefined;
  initiatorName: string | undefined;
  businessUnit: string | undefined;
  contactNumber: string | undefined;
  user: any;

  constructor(private propertyValuationService: PropertyValuationService,private route: ActivatedRoute,private router : Router  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log('Route Parameters:', params);
      this.user = params;
    });
    this.route.params.subscribe(params => {
      // Retrieve user details from route parameters
      const userDetails = params;
      console.log(userDetails);
      // Set user details to component properties
      this.initiatorName = userDetails['initiatorName'];
      this.businessUnit = userDetails['businessUnit'];
      this.contactNumber = userDetails['contactNumber'];
      // Set other user details accordingly
    });
    };
    facility: FacilityDetail = new FacilityDetail();
    submitForm() {
      // Validate form data
      if (!this.typeOfEvaluation) {
        // Display error message or perform validation logic
        console.error('Type of Evaluation is required.');
        return; // Prevent form submission if data is invalid
      }
      
  
      if (this.typeOfEvaluation === 'Existing' && !this.fosReference) {
        // Display error message or perform validation logic
        console.error('FOS Reference is required for Existing type.');
        return; // Prevent form submission if data is invalid
      }
  
      // If form data is valid, proceed with submission
      console.log('Form submitted successfully!');
      console.log('Type of Evaluation:', this.typeOfEvaluation);
      console.log('FOS Reference:', this.fosReference);

      if (this.typeOfEvaluation === 'Existing' && this.fosReference) {
            this.router.navigate(['/existingproperty',this.fosReference]); // Replace '/browser' with your desired route
      }

      if (this.typeOfEvaluation=== 'New'){
        this.router.navigate(['/newproperty',this.user]);
      }

  
      // Optionally, you can submit the form data to a backend service here
      // For example:
      // this.propertyValuationService.submitForm(this.facility).subscribe(response => {
      //   console.log('Form submitted successfully:', response);
      //   // Optionally, navigate to another page upon successful form submission
      //   // this.router.navigate(['/success']);
      // }, error => {
      //   console.error('Error submitting form:', error);
      //   // Handle error response
      // });
    }
  }

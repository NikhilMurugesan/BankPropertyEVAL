import { Component, OnInit } from '@angular/core';
import { PropertyValuationService } from '../property-valuation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FacilityDetail } from '../FacilityDetail.model';
@Component({
  selector: 'app-property-valuation',
  templateUrl: './property-valuation.component.html',
  styleUrl: './property-valuation.component.css'
})
export class PropertyValuationComponent implements OnInit{

  
  fosReference: string | undefined;
  typeOfEvaluation: string | undefined;
  initiatorName: string | undefined;
  businessUnit: string | undefined;
  contactNumber: string | undefined;
  typesOfFacility: any[] = [];
  categories: any[] = [];
  purposesOfValuation: any[] = [];
  currencies: any[] = [];
  isNewEvaluation: boolean = true; // Flag to determine if it's a new evaluation
  typeOfFacility: string | undefined;
  category: string | undefined;
  purpose: string | undefined;
  term: number | undefined;
  currency: string | undefined;
  amount: number | undefined;
  user: any;

  constructor(private propertyValuationService: PropertyValuationService,private route: ActivatedRoute,private router : Router  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log('Route Parameters:', params);
      this.user = params;
    });
    this.propertyValuationService.getTypeOfFacility().subscribe(data => {
      this.typesOfFacility = data;
    });

    this.propertyValuationService.getCategories().subscribe(data => {
      this.categories = data;
    });

    this.propertyValuationService.getPurposesOfValuation().subscribe(data => {
      this.purposesOfValuation = data;
    });

    this.propertyValuationService.getCurrencies().subscribe(data => {
      this.currencies = data;
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
    onTypeOfFacilityChange(event: Event)
    {
      const target = event.target as HTMLSelectElement;
      this.typeOfFacility = target.value;
     
    }
    onCategoryChange(event: Event)
    {
      const target = event.target as HTMLSelectElement;
      this.category = target.value;
     
    }
    onCurrencyChange(event: Event)
    {
      const target = event.target as HTMLSelectElement;
      this.currency = target.value;
     
    }
    onPurposeChange(event: Event)
    {
      const target = event.target as HTMLSelectElement;
      this.purpose = target.value;
     
    }
    submitForm()
    {
      this.facility.type = this.typeOfFacility;
      this.facility.category = this.category;
      this.facility.purpose = this.purpose;
      this.facility.termMonths = this.term;
      this.facility.currency = this.currency;
      this.facility.amount = this.amount;
      console.log(this.facility);
      this.propertyValuationService.createPropertyValuationData(this.facility).subscribe({
        
        next: (data) => {
        
          // Handle success response
          console.log('Property valuation submitted successfully:', data);
          // Navigate to browser or perform other actions upon success
          this.router.navigate(['/b', this.user]); // Replace '/browser' with your desired route
        },
        error:  (error) => {
          // Handle error response
          console.error('Error submitting property valuation:', error);
          // You can display an error message or perform other error handling here
        }}
      );
    }
  }

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PropertyValuationService } from '../property-valuation.service';
import { FacilityDetail } from '../FacilityDetail.model';

@Component({
  selector: 'app-existing-property',
  templateUrl: './existing-property.component.html',
  styleUrls: ['./existing-property.component.css']
})
export class ExistingPropertyComponent implements OnInit {
  existingProperties: any[] = [];
  facilityDetail: FacilityDetail = new FacilityDetail();
  constructor(private propertyValuationService: PropertyValuationService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const fosReference = params['fosReference'];
      if (fosReference) {
        this.propertyValuationService.getPropertyDetailsByFOSReference(fosReference).subscribe({
          next: (response) => {
            console.log('Property details retrieved successfully:', response);
           this.existingProperties = response;
           console.log(this.existingProperties); // Assign response to existingProperties array
          },
          error: (error) => {
            console.error('Error retrieving property details:', error);
          }
        });
      }
    });
  }
}

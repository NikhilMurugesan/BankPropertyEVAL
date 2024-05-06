import { Component } from '@angular/core';
import { PropertyValuationService } from '../property-valuation.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {
  data: any[] | undefined;

  constructor(private propertyValuationService: PropertyValuationService) { }
  ngOnInit(): void {
    this.propertyValuationService.getallApplications().subscribe(response => {
      this.data = response;
    });
  }
} 

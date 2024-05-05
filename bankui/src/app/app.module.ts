import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { MatMenuModule } from '@angular/material/menu';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { HomepageComponent } from './homepage/homepage.component';
import { PropertyValuationComponent } from './property-valuation/property-valuation.component';
import { HttpClientModule } from '@angular/common/http';
import { BorrowerComponent } from './borrower/borrower.component';
import { NewPropertyComponent } from './new-property/new-property.component';
import { ExistingPropertyComponent } from './existing-property/existing-property.component';
import { CommentComponent } from './comment/comment.component';@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomepageComponent,
    PropertyValuationComponent,
    BorrowerComponent,
    NewPropertyComponent,
    ExistingPropertyComponent,
    CommentComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
    MatMenuModule,
    HttpClientModule
    
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }

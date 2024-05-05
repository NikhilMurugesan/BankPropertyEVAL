import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PropertyValuationComponent } from './property-valuation/property-valuation.component';
import { BorrowerComponent } from './borrower/borrower.component';
import { NewPropertyComponent } from './new-property/new-property.component';
import { ExistingPropertyComponent } from './existing-property/existing-property.component';
//import { CommentComponent } from './comment/comment.component';

const routes: Routes = [/*  {
  path: '',
  component: LoginComponent,
},*/
{
  path: 'login',
  component: LoginComponent,
},
{
  path: 'homepage',
  component: HomepageComponent,
}, 
{
  path: 'b',
  component: BorrowerComponent,
}, 
{ path: 'p', component: PropertyValuationComponent },
{ path: 'newproperty', component: NewPropertyComponent},
{ path: 'borrower', component: BorrowerComponent },
{ path: 'existingproperty', component: ExistingPropertyComponent},
{ path: 'existingproperty/:fosReference', component: ExistingPropertyComponent},
//{ path: 'comment', component: CommentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

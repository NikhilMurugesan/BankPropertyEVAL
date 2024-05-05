import { Borrower } from "./borrower.model";

export class JointBorrowers {
    customerNumber: string| undefined;
    customerName: string| undefined;
    contactNumber: string| undefined;
    email: string| undefined;
    address: string| undefined;
    mainBorrower: Borrower | null | undefined;
    jointborrowerID: number | undefined;
    constructor(
      
    ) {
     
    }
  }
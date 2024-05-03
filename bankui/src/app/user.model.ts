export class User {
    id !: number | undefined;
    username!: string;
    password!: string;
    initiatorName?: string; // Non-editable field
    businessUnit?: string; // Non-editable field
    contactNumber?: string;
    constructor(){}
  
  }
  
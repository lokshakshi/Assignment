import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { DataSource } from '@angular/cdk/table';
import {DomSanitizer} from '@angular/platform-browser';
import {MatIconRegistry} from '@angular/material/icon';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RegisterService } from '../register.service';

export class Manager{
  id:any;
  email:any;
  password:any;
  fname:any;
  lname:any;
  dob:any;
  company:any;

}
@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})

export class RegisterUserComponent implements OnInit {
saveData:any;
id:any;
email:any;
password:any;
fname:any;
lname:any;
dob:any;
company:any;
  constructor(private registerService:RegisterService,public dialog:MatDialog,
    private snackBar:MatSnackBar) { }

  ngOnInit(): void {
  }

  //Adding Manager Details
saveManager()
{
  this.saveData=new Manager();
  this.saveData.id=this.id;
  this.saveData.email=this.email;
  this.saveData.password=this.password;
  this.saveData.fname=this.fname;
  this.saveData.lname=this.lname;
  this.saveData.dob=this.dob;
  this.saveData.company=this.company;

  console.log("this.saveData",this.saveData);

  this.registerService.registerManager(this.saveData).subscribe(x=>{
    this.snackBar.open('Manager Details updated Succesfully','close',{
      duration:4000,
      verticalPosition:'top'
    });
  },
  err=>{
    this.snackBar.open('Manager Details are not updated','close',{
      duration:4000,
      verticalPosition:'top'
    });
  });

  // this.dialogRef.close();
}
}

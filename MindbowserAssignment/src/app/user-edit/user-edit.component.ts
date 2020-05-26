import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { DataSource } from '@angular/cdk/table';
import {DomSanitizer} from '@angular/platform-browser';
import {MatIconRegistry} from '@angular/material/icon';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../user.service';

export class User{
id:any;
fname:any;
lname:any;
mobile:any;
dob:any;
city:any;
address:any;
}
@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
id:any;
fname:any;
lname:any;
mobile:any;
dob:any;
city:any;
address:any;
UserEditData:any;
saveData:any;
  constructor(public dialogRef:MatDialogRef<UserEditComponent>,
    @Inject(MAT_DIALOG_DATA) public userdata:any,private userService:UserService,public dialog:MatDialog,
    private snackBar:MatSnackBar) { 
      this.UserEditData=userdata;
      if(this.UserEditData.editdata !=undefined){
      this.id=this.UserEditData.editdata.id;
      this.city=this.UserEditData.editdata.city;
      this.dob=this.UserEditData.editdata.dob;
      this.address=this.UserEditData.editdata.address;
      this.mobile=this.UserEditData.editdata.mobile;
      this.fname=this.UserEditData.editdata.fname;
      this.lname=this.UserEditData.editdata.lname;
    }
    }
  ngOnInit(): void {
  }


  //Saving User details
saveUser(){

  this.saveData=new User();
  this.saveData.id=this.id;
  this.saveData.city=this.city;
  this.saveData.dob=this.dob;
  this.saveData.address=this.address;
  this.saveData.mobile=this.mobile;
  this.saveData.fname=this.fname;
  this.saveData.lname=this.lname;

  this.userService.saveUser(this.saveData).subscribe(x=>{
    this.snackBar.open('User Details updated Succesfully','close',{
      duration:4000,
      verticalPosition:'top'
    });
  },
  err=>{
    this.snackBar.open('User Details are not updated','close',{
      duration:4000,
      verticalPosition:'top'
    });
  });

  this.dialogRef.close();
}
}

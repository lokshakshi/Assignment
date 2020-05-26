
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { DataSource } from '@angular/cdk/table';
import {DomSanitizer} from '@angular/platform-browser';
import {MatIconRegistry} from '@angular/material/icon';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../user.service';
import { UserEditComponent } from '../user-edit/user-edit.component';

export interface Element{

  EmpId:string;
  firstName:string;
  lastName:string;
  address:string;
  dob:string;
  mobile:string;
  city:string;
}
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  displayedColumns: string[] = ['EmpId', 'firstName' , 'lastName' , 'address','dob','mobile','city','editIcon','deleteIcon'];
 @ViewChild(MatSort, {static: true}) sort: MatSort;
 dataSource: MatTableDataSource<Element>;
 renderedData: any;
 tableData : Element[];

  constructor(private userService : UserService,iconRegistry: MatIconRegistry, sanitizer: DomSanitizer, public dialog: MatDialog ,private snackBar: MatSnackBar) {
    
   }

  ngOnInit(): void {
    this.getData();
  }

  //Fetching User Details
  getData(){
    this.userService.getUserData().subscribe((data : any[]) => {
     console.log(data); 
     data.sort();  
     this.tableData = data; 
     this.dataSource = new MatTableDataSource(this.tableData);  
     this.dataSource.connect().subscribe(d => this.renderedData = d);  
     this.dataSource.sort = this.sort;
  
    });
  
   }

   //Deleting User
   deleteUser(data)
   {
      console.log("deleteUserDetails:", data);
      this.userService.deleteUser(data.id).subscribe(data=>{
        this.snackBar.open('User Deleted Successfully.','close',{
          duration:4000,
          verticalPosition:'top'
        });
      },error=>{
        this.snackBar.open('could not delete user', 'close',{
          duration:4000,
          verticalPosition:'top'
        })
      });
   }

   //Editing User
   editUser(data)
   {
     const dialogRef=this.dialog.open(UserEditComponent,{
       width:'30vw',
      data:{editdata: data}
     });

   }

//Adding New User
   addUser(){
    const dialogRef=this.dialog.open(UserEditComponent,{
      width:'30vw',
     data:{editdata: []}
    });
   }

}

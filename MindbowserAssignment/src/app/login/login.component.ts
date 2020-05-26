import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ManagerServiceService } from '../manager-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  dataRecieved:any;
  public email:any;
  public password:any;
  check: any;
  constructor(private router : Router, private managerdetails:ManagerServiceService) { }

  ngOnInit(): void {
  }
register()
{
  
   this.router.navigate(['/RegisterUser']);
}
login()
{

  this.dataRecieved=this.managerdetails.getManagerDetails().subscribe((data:any[])=>{

  this.check=data.filter(item=>
    {
      if((item.email===this.email )&& (item.password===this.password)) {
            return item;
          }
    });
});
  if(this.check!=undefined){
  this.router.navigate(['/UserDetails']);
  }
}
}

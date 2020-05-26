import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment'
// import { ConsoleReporter } from 'jasmine';

@Injectable({
  providedIn: 'root'
})
export class ManagerServiceService {
managerDetailsURl:any;
DataChecking:any;
  constructor(private http:HttpClient)
   { 
     this.managerDetailsURl=environment.managerDetailsURl;
   }
getManagerDetails()
{
  // this.DataChecking=this.http.get(this.managerDetailsURl);
  // console.log("DataChecking",this.DataChecking);
  return this.http.get(this.managerDetailsURl);
}
}

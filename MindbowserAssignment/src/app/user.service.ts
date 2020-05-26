import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userDetails:any;
  DataChecking:any;
  UserDeleteUrl:any;
  UserEditUrl:any;
    constructor(private http:HttpClient)
     { 
       this.userDetails=environment.UserDetailsUrl;
       this.UserDeleteUrl=environment.UserDeleteUrl;
       this.UserEditUrl=environment.UserEditUrl;
     }
  

  getUserData()
  {
    return this.http.get(this.userDetails);
  }

  deleteUser(id)
  {
const httpOptions={
headers:new HttpHeaders({
  'Content-Type' :'application/json'
})
};
const url=`${this.UserDeleteUrl}/${id}`;
return this.http.delete(url,httpOptions);
  }

  saveUser(data)
  {
    const httpOptions={
      headers:new HttpHeaders({
        'Content-Type' :'application/json'
      })
  };
  return this,this.http.post<any>(this.UserEditUrl,JSON.stringify(data),httpOptions);
}

}

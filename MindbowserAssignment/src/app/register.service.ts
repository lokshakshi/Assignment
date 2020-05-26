import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
registerManagerurl:any;
  constructor(private http:HttpClient) {
    this.registerManagerurl=environment.RegisterManagerUrl;
   }
  registerManager(data)
  {
    const httpOptions={
      headers:new HttpHeaders({
        'Content-Type' :'application/json'
      })
  };
  return this,this.http.post<any>(this.registerManagerurl,JSON.stringify(data),httpOptions);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import * as http from '@angular/common/http';
import {User} from './User';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  user = new User();
  constructor(public http: HttpClient) { }

  setUser(user: User): void {

    this.user.password = user.password;
    this.user.tel = user.tel;

    var data = this.http.post("http://localhost:8888/login",this.user)
      .subscribe(next => console.log(next));

  }



}

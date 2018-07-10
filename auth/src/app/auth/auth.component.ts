import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../user.service';
import * as http from '@angular/common/http';
import {HttpClient} from '@angular/common/http';
import {User} from '../User';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  validateForm: FormGroup;

    user = new User();

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }

    this.setUser();
  }


  constructor(private fb: FormBuilder, private userService:UserService) {
  }

  setUser():void {
    this.user.tel = this.validateForm.get('userName').value;
    this.user.password = this.validateForm.get('password').value;
    this.userService.setUser(this.user);

  }
  ngOnInit(): void {
    this.validateForm = this.fb.group({
      userName: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });
  }
}

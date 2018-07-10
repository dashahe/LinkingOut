import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-auth',
  templateUrl: './user-auth.component.html',
  styleUrls: ['./user-auth.component.css']
})

export class UserAuthComponent implements OnInit {

  isLoading = false;
  // the time out is 5000 millis
  timeOut = 5000;

  postAuthLoading(): void {
    this.isLoading = true;
    setTimeout(_ => {
      this.isLoading = false;
    },this.timeOut);
  }


  constructor() { }

  ngOnInit() {
  }

}

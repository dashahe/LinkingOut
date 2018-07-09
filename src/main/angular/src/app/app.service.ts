import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: Http) {

  }

  getUserList(): Promise<any> {
    const url = '/test';
    return this.http.get(url)
      .toPromise()
      .then(response => response.json())
      .catch(this.handleError);
  }

  private handleError(error: Response | any) {
    let errMsg: string;
    console.error(errMsg);
    return Promise.reject(errMsg);
  }
}

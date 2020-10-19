import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../services/user.service.client';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private userService: UserService) { }
  username: string;
  password: string;
  ngOnInit(): void {  }

  // tslint:disable-next-line:typedef
  login(username, password) {
    console.log(username, password);
    const user = this.userService.findUserByCredentials(username, password);
    if (user != null) {
      this.router.navigate(['profile', user.id]);
    }
  }
}

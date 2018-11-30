import {Component, OnInit} from '@angular/core';
import {ExpressoService} from '../services/expresso.service';
import {Route, Router, RouterModule} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  userLoggedIn: boolean;
  user: string;
  pageLoaded = false;

  constructor(private service: ExpressoService, private route: Router) {
    this.service.loggedIn()
      .then(() => {
        this.userLoggedIn = this.service.userLoggedIn;
        console.log(this.userLoggedIn);
      });
    this.service.getUser()
      .then(() => {
        this.user = this.service.user.first_name;
      });
  }

  ngOnInit() {

  }

  logout() {
    this.service.logout()
      .then(() => {
          location.reload();
        }
      );
  }

}

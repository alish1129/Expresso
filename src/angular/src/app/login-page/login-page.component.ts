import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ExpressoService} from '../services/expresso.service';
import {Router, RouterModule} from '@angular/router';
import {ModalDirective} from 'angular-bootstrap-md';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {
  @ViewChild('successModal') successModal: ModalDirective;

  loggedIn: boolean;
  loginMessage: string;

  constructor(private service: ExpressoService, private router: Router) {
    // if (localStorage.getItem('PortalAdminHasLoggedIn') === '' && localStorage.getItem('PortalAdminHasLoggedIn') == null) {
    //   this.loggedIn = false;
    // } else {
    //   this.loggedIn = true;
    //   console.log(localStorage.getItem('PortalAdminHasLoggedIn'));
    //
    // }
    // console.log(this.loggedIn);
  }

  ngOnInit() {

  }

  submit(f: NgForm) {

    const value = f.value;

    this.service.login(value)
      .then(() => {
        this.loggedIn = this.service.userLoggedIn;
        localStorage.setItem('PortalAdminHasLoggedIn', 'true');
        console.log('Successful');
        console.log(localStorage.getItem('PortalAdminHasLoggedIn'));
      })
      .then(() => {
        this.router.navigate([''])

      })
      .catch(() => {
        this.loginMessage = 'Please make sure you entered valid username and password.';
        this.successModal.show();

        setTimeout(() => {
          this.successModal.hide();
        }, 2000);
      });
  }
}

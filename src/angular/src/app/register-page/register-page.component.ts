import {Component, OnInit, ViewChild} from '@angular/core';
import {User} from '../types/user';
import {ExpressoService} from '../services/expresso.service';
import {Router} from '@angular/router';
import {ModalDirective} from 'angular-bootstrap-md';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.scss']
})
export class RegisterPageComponent implements OnInit {
  @ViewChild('successModal') successModal: ModalDirective;

  user: User = {
    email: '',
    password: '',
    first_name: '',
    last_name: '',
    username: '',
    dob: '',
    enabled: 1
  };
  confirmPassword = '';

  message = 'Registration Successful';


  constructor(private expresso: ExpressoService, private route: Router) {
  }

  ngOnInit() {
  }

  register() {
    this.expresso.signUp(this.user)
      .then(() => this.route.navigate(['signin']))
      .catch(() => {
        this.message = this.expresso.regisMessage;
        this.successModal.show();


        setTimeout(() => {
          this.successModal.hide();
        }, 3000);
      });
  }


  validPassword() {
    return this.user.password === this.confirmPassword && this.user.password.length > 8;
  }

  validEmail() {
    return this.user.email.includes('@');
  }

  validInput() {
    console.log(this.validEmail());
    console.log(this.validPassword());
    return this.user.first_name.length > 0 && this.user.last_name.length > 0
      && this.validEmail() && this.validPassword() && this.user.username.length > 0;
  }
}

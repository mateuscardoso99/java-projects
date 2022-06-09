import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null,
    roles: []
  };
  roles = ['user','mod','admin'];
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) { }

  ngOnInit(): void {}

  onCheckboxChange(e: any) {
    if (e.target.checked) {
      this.form.roles.push(e.target.value);
    } else {
      this.form.roles.splice(this.form.roles.indexOf(e.target.value),1)
    }
    console.log(this.form)
  }

  onSubmit(): void {
    const { username, email, password, roles } = this.form;
    this.authService.register(username, email, password, roles).subscribe({
      next: data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    });
  }
}
import {Component, NgZone, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../service/auth/auth.service';
import {TokenStorage} from '../service/auth/token.storage';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public incorrect: boolean = false;

  formGroup: FormGroup;

  constructor(private router: Router,
              private authService: AuthService,
              private zone: NgZone,
              private token: TokenStorage) {
  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      Username: new FormControl('', [
        Validators.required
      ]),
      Password: new FormControl('', [
        Validators.required
      ])
    });
  }

  onSubmit() {
    this.login();
  }


  login(): void {
    this.authService.attemptAuth(this.formGroup.value.Username, this.formGroup.value.Password).subscribe(
      data => {
        this.token.saveToken(data.token);
        setTimeout(() => {
            this.reloadPage();
          },
          100);
        this.router.navigate(['']);
      }, () => {
        this.incorrect = true;
      }
    );
  }

  closeAlert(): void {
    this.incorrect = false;
  }

  reloadPage() {
    this.zone.runOutsideAngular(() => {
      location.reload();
    });
  }


}

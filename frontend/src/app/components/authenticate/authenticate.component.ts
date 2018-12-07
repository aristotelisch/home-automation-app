import { Component, OnInit } from '@angular/core';
import {AppService} from '../../services/app.service';
import {HttpClient} from '@angular/common/http';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {MessageService} from 'primeng/api';


@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.css']
})

export class AuthenticateComponent implements OnInit {

  model: any = {};

  constructor(
    private app: AppService,
    private http: HttpClient,
    private router: Router,
    private route: ActivatedRoute,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    sessionStorage.setItem('token', '');
  }

  login() {
    const url = 'http://localhost:8080/login';
    this.http.post<Observable<boolean>>(url, {
      username: this.model.username,
      password: this.model.password
    }).subscribe(isValid => {
      if (isValid) {
        this.app.setToken(btoa(this.model.username + ':' + this.model.password));

        this.app.authenticate(() => {
          this.router.navigate(['/dashboard']);
        });

        this.router.navigate(['/dashboard']);

      } else {
        this.addSingleMessagePopUp('error', 'Authentication Failed', isValid);
      }
    });
  }

  addSingleMessagePopUp(severity, summary, detail) {
    this.messageService.add({severity: severity, summary: summary, detail: detail});
    setTimeout(() => {
      console.log('hide');
      this.clearMessagePopUp();
    }, 3000);
  }

  clearMessagePopUp() {
    this.messageService.clear();
  }
}

import { Component } from '@angular/core';
import { AppService } from './services/app.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Home Automation App';
  authenticated = false;

  constructor(private app: AppService, private http: HttpClient, private router: Router) {
    // this.app.authenticate(undefined, undefined);
  }

  logout() {
    this.http.post('logout', {}).subscribe(() => {
      this.app.authenticated = false;
      this.router.navigateByUrl('/authenticate');
    });
  }

}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FrontEnd';
  componentForm =true ;
  constructor(private router: Router) { }
  SignUp() {
    this.componentForm=false;
    this.router.navigate(['/sign-up']); // Replace '/your-route' with the desired route path
  }
}

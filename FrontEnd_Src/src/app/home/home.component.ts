import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import{ProfileComponent} from '../profile/profile.component'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  title = 'FrontEnd';
  componentForm =true ;
  formSingIn:any={}
  presonName:any;
  constructor(private router: Router,private http: HttpClient) {

   }

  SignUp() {
    this.componentForm=false;
    this.router.navigate(['/sign-up']); // Replace '/your-route' with the desired route path
  }
  
  onSubmit() { 
    console.log("Erro why that ",this.formSingIn);
    this.http.post("http://localhost:8080/NoteBook/signIn",this.formSingIn,{
      responseType:'text',
      observe:'response'
    }).subscribe(response=>{
      console.log('Data sent successfully!', response);
      this.componentForm=false;
      this.presonName=response.body;
      this.router.navigate(['/profile',this.presonName]);
    })
  }
}
export default HomeComponent 

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {HomeComponent} from '../home/home.component'
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  FormSignUp=true
  formData:any={}
  instanceA:any
  constructor(private router: Router,private http: HttpClient) {
    this.instanceA= new HomeComponent(router,http);
  }

  // deletePage1() {
  //   this.router.navigateByUrl('/', { replaceUrl: true });
  // }
  SignUp(){
    this.FormSignUp=false;
    console.log(this.instanceA.componentForm)
    this.instanceA.componentForm=true
    this.router.navigate(['']); // Replace '/your-route' with the desired route path
    console.log('component from',this.instanceA.componentForm)
    // this.componentForm=false;
    // this.router.navigate(['/profile']); // Replace '/your-route' with the desired route path
  }

  onSubmit() { 
    console.log(this.formData);
    this.http.post("http://localhost:8080/NoteBook/signUp",this.formData,{
      responseType:'text',
      observe:'response'
    }).subscribe(response=>{
      this.FormSignUp=false;
      this.instanceA.componentForm=true
      this.router.navigate(['']); // Replace '/your-route' with the desired route path
      console.log('Data sent successfully!', response);
    })
  }

}

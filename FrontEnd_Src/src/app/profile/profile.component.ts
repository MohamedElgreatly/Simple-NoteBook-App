import { Component, EventEmitter, Host, Input, OnInit, Output } from '@angular/core';
import{HomeComponent} from '../home/home.component'
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  formButton=false
  NoteButton=false
  formData:any={}
  items: string[] = [];
  receivedVariable:any;
  constructor(private router: Router,private http: HttpClient,private route: ActivatedRoute) {
    
  }
  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      // Access the parameter value
      this.receivedVariable = params.get('variable');
      this.formData.userName=this.receivedVariable
    });
  }
  AddNotes(){
   this.formButton=true 
   this.NoteButton=false
   
  }
  enableNotes(){
    this.NoteButton=true 
    this.formButton=false
    console.log(this.receivedVariable,'  oooo');
    this.http.get<any[]>(`http://localhost:8080/NoteBook/getNotes?userName=${this.receivedVariable}`,{
      responseType:'json',
      observe:'response'
    }).subscribe(response=>{
      console.log('Data sent successfully!', response);
      this.items=[]
      if (response.body) {
      for (let item of (response.body)) {
        console.log(item.text); // Do something with each item
        this.items.push(item.text)
      }
    }
    })
  }
  onSubmit(){
    this.http.post("http://localhost:8080/NoteBook/AddNote",this.formData,{
      responseType:'text',
      observe:'response'
    }).subscribe(response=>{
      console.log('Data sent successfully!', response);
      
    })
  }
}

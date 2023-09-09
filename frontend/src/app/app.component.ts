import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable, catchError, map, tap, throwError } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  
  constructor(private http: HttpClient) { }


  name: string = '';

  isSubmitting: boolean = false;
 
  isSpecialCharcterFound: boolean =false;
  regex = new RegExp("^[a-zA-Z0-9 ]+$");

  response: any = undefined;
  baseUrl: string = "http://localhost:8080/"
  responseL: string = ''
  lastEnteredName: string =''
  isSameName :boolean= false
 

   inputChanged(event:any){

    this.name= event.target.value
    this.isSameName=false
    this.isSpecialCharcterFound= this.name.match(/[^a-zA-Z ]+/) ? true : false;


    console.log(this.isSpecialCharcterFound)
    console.log( this.name)
   }

   onSubmit(){
    console.log("URL : "+this.baseUrl)
    console.log("name : "+this.name)

  

    if(this.name === this.lastEnteredName){
      this.response = undefined
      this.isSameName=true

    }else{
      this.isSameName=false
      this.lastEnteredName = this.name

      this.getData().subscribe(
        (response) => {
          // Handle the successful response here
          this.response = response
          console.log(response);
        },
        (error) => {
          // Handle errors here
          console.error(error);
        }
      )
    }

    
   }


  getData(): Observable<any> {
    return this.http.post(this.baseUrl,this.name, {
      responseType: "text"});
  }

 
}

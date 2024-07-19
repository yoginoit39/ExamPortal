import { Component } from '@angular/core';
import { ColdObservable } from 'rxjs/internal/testing/ColdObservable';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})



export class SignupComponent {

  constructor(private userService:UserService){}

  public user = {
    username: "",
    password: "",
    firstname: "",
    lastname: "",
    email: "",
    phone: "",
  };

  formSubmit(){
    console.log(this.user);
    if(this.user.username == "" || this.user.username == null){
      alert("username can't be empty");
      return
    }

    //addUser: userService
    this.userService.addUser(this.user).subscribe(
      (data) => {
          //success
          console.log(data);
          alert('success');
      },
      (error)=>{
        //error
        console.log(error);
        alert('something went wrong');
      }
    );
  }

}

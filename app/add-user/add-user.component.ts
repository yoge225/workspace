import { Component, OnInit, NgModule } from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormControl} from "@angular/forms";
import {Router} from '@angular/router';
import {UserService} from 'src/service/service/user.service';
import { User } from 'src/model/user.model';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private userService: UserService) { }

  addForm: FormGroup;
  userData : Observable<User>;
   map:any;
  ngOnInit() {
    
    this.addForm = this.formBuilder.group({
      id: [],
      emailId: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required]
    });

  }

  createUser() {
    
      this.userService.createUser(this.addForm.value).pipe(
        map((user) => map((item: any) =>  {
              
              const userModel= new User();
              
              Object.assign(user,item);
              if(item.completed){

                userModel.completed = 'completed';
             }else{
                userModel.completed = 'pending';
             }
            return userModel;
         }))).subscribe( data =>  {

        console.log("userData:"+data);
   // this.router.navigate(['user']);
        this.router.navigate(['add']);
        console.log("userData:"+data);
      });
     
    }
    


}

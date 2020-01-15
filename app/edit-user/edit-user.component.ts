import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from '@angular/router';
import { UserService } from 'src/service/service/user.service';
import { User } from '../../model/user.model';
import { first } from "rxjs/operators";
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { from } from 'rxjs';
@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  userData: Observable<User[]>
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    if (!userId) {
      alert("Invalid action.")
      this.router.navigate(['edit']);
      return;
    }
    this.editForm = this.formBuilder.group({
      userId: [],
      emailId: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required]
    });
    this.userService.getUserById(+userId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }

  editUser() {
    console.log("Edit page:::");
    this.userService.updateUser(this.editForm.value)
           .pipe(map((user) => map((item: any) => {

                const userModel = new User();
                console.log("After Edit page:::");
                Object.assign(user, item);
              if (item.completed) {

                userModel.completed = 'completed';
                    }    
                    else {

                   userModel.completed = 'pending';
               }
        
             return userModel;
      
            }))).subscribe(data => {

               console.log("userData:" + data);
        // this.router.navigate(['user']);
              this.router.navigate(['edit']);
        console.log("userData:" + data);
      });


    // .subscribe(
    //   data => {
    //     this.router.navigate(['edit']);
    //   },
    //   error => {
    //     alert(error);
    //   });
    }

}

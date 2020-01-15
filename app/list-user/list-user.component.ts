import { Component, OnInit } from '@angular/core';
import {User} from 'src/model/user.model';
import {Router} from '@angular/router';
import {UserService} from 'src/service/service/user.service';
import {FormGroup, FormControl, FormsModule} from '@angular/forms';
import { from } from 'rxjs';
@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {
  users: User[];

  constructor(private router: Router, private userService: UserService) {
   
   }

 
  ngOnInit() {
    this.userService.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user.userId)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      })
  };

  editUser(user: User): void {
    localStorage.removeItem("userId");
    console.log("userId:"+user.userId);
    localStorage.setItem("userId", user.userId.toString());
    this.router.navigate(['edit']);
  };

  createUser(): void {
    this.router.navigate(['add']);
  };

}

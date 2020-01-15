import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {User} from 'src/model/user.model';
import { map } from 'rxjs/operators';
import { from, Observable } from 'rxjs';

    
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
let options = {
  headers: httpOptions
}

   
@Injectable({
  providedIn: 'root'
})
export class UserService {

  users: User[];
  firstName: String;
  lastName: String;
  emailId: String;
  
   user:Observable<User[]>
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/users';
    //private baseUrl='/users';
  getUsers() {
 
    return this.http.get<User[]>(this.baseUrl + "/list");
  }

  getUserById(userId: number) {
    return this.http.get<User>(this.baseUrl + '/user/' + userId);
  }

  createUser(user: User) {
    console.log("Hiii");
    
    return this.http.post(this.baseUrl + '/add', user);

       

    //return this.http.post<User>(this.baseUrl+ '/add', user).pipe(map(response=> response.userId));
      }

  updateUser(user: User) {
    return this.http.put(this.baseUrl + '/edit/{id}' + user.userId, user);
  }

  deleteUser(userId: number) {
    return this.http.delete(this.baseUrl + '/user/' + userId);
  }

}

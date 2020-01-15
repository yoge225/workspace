import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddUserComponent}  from '../app/add-user/add-user.component';
import {EditUserComponent} from '../app/edit-user/edit-user.component';
import {ListUserComponent} from '../app/list-user/list-user.component';
import { AppComponent } from './app.component';

const routes: Routes = [

  { path: 'add', component:AddUserComponent},
  { path: 'edit', component:EditUserComponent},
  { path: 'list', component: ListUserComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

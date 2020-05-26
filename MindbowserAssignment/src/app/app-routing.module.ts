import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserComponent } from './user/user.component';


const routes: Routes = [
   {path:'',component:LoginComponent},
  {path:'RegisterUser',component:RegisterUserComponent},
  {path:'UserDetails',component:UserComponent
}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {DashboardComponent} from "./features/dashboard/dashboard.component";
import {LoginComponent} from "./features/login/containers/login/login.component";
import {RoleGuardService} from "./core/services/role-guard/role-guard.service";
import {LoginGuardService} from "./core/services/login-guard/login-guard.service";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full',

  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [LoginGuardService],
    data: {permission: 'USER_MANAGEMENT,BUG_MANAGEMENT,PERMISSION_MANAGEMENT'},

    children: [
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',

      },
      {
        path: 'users',
        loadChildren: 'src/app/features/users/users.module#UsersModule',
        canActivate: [RoleGuardService],
        data: {permission: 'USER_MANAGEMENT'},
      },
      {
        path: 'notifications',
        loadChildren: 'src/app/features/notifications/notifications.module#NotificationsModule'
      },
      {
        path: 'bugs',
        loadChildren: 'src/app/features/bugs/bugs.module#BugsModule',
        canActivate: [RoleGuardService],
        data: {permission: 'BUG_MANAGEMENT'},

      },
      {
        path: 'permissions',
        loadChildren: 'src/app/features/permission-manager/permission-manager.module#PermissionManagerModule',
        canActivate: [RoleGuardService],
        data: {permission: 'PERMISSION_MANAGEMENT'},
      },
    ]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

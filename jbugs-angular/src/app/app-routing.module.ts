import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {DashboardComponent} from "./features/dashboard/dashboard.component";
import {LoginComponent} from "./features/login/containers/login/login.component";

/*
const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    children: [
      {
        path: '',
        redirectTo: 'users',
        pathMatch: 'full'
      },
      {
        path: 'users',
        children: [
          {
            path: '',
            component: UsersComponent,
          },
          {
            path: ':userId',
            children: [
              {
                path: 'edit',
                component: UserEditComponent
              }
            ]

          }
        ]
      },
      {
        path: 'bugs',
        component: BugsComponent
      }
    ]
  }
];
*/

const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  // {
  //   path: 'insertorremovepermission',
  //   loadChildren: 'src/app/features/permission-manager/permission-manager.module#PermissionManagerModule'
  // },
  {
    path: 'dashboard',
    component: DashboardComponent,
    children: [
      {
        path: '',
        redirectTo: 'users',
        pathMatch: 'full'
      },
      {
        path: 'users',
        loadChildren: 'src/app/features/users/users.module#UsersModule'
      },
      {
        path: 'notifications',
        loadChildren: 'src/app/features/notifications/notifications.module#NotificationsModule'
      },
      {
        path: 'permissions',
        loadChildren: 'src/app/features/permission-manager/permission-manager.module#PermissionManagerModule'
      },
    ]
  }
]



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

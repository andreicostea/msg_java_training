import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {DashboardComponent} from "./features/dashboard/dashboard.component";
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
        path: 'bugs',
        loadChildren: 'src/app/features/bugs/bugs.module#BugsModule'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

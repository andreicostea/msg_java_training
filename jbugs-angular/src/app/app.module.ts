import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {
  MatButtonModule,
  MatCheckboxModule,
  MatDialogModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatLineModule,
  MatMenuModule,
  MatNativeDateModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule
} from "@angular/material";
import {DashboardComponent} from "./features/dashboard/dashboard.component";
import {LoginComponent} from "./features/login/containers/login/login.component";
import {LoginModule} from "./features/login/login.module";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AddHeaderInterceptor} from "./core/backend/request.interceptor";

import {UsersModule} from "./features/users/users.module";
import {BugsModule} from "./features/bugs/bugs.module";

import {NotificationsModule} from "./features/notifications/notifications.module";

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,


  ],
  //entryComponents:[BugsTableComponentComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatTableModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    LoginModule,
    BrowserAnimationsModule,
    MatNativeDateModule,
    MatButtonModule,
    MatTabsModule,
    MatLineModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    MatMenuModule,
    MatIconModule,
    MatToolbarModule,
    UsersModule,
    BugsModule,
    NotificationsModule,
    MatSortModule

  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AddHeaderInterceptor,
    multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}

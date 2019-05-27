import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { DashboardComponent } from "./features/dashboard/dashboard.component";
import { PermissionsComponent } from './features/permissions/containers/permissions.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    PermissionsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

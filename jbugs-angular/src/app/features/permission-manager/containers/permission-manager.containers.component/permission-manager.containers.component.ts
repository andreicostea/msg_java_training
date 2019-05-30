import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PermissionService} from "../../services/permission-manager.services";
import {Permission} from "../../model/permission-manager.model";

@Component({
  selector: 'app-permission-manager',
  templateUrl: './permission-manager.containers.component.html',
  styleUrls: ['./permission-manager.containers.component.css']
})
export class PermissionManagerInsertComponent implements OnInit {
  public permission: Permission = new Permission();

  constructor(private servicePermission: PermissionService,
              private activateRouter: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
  }

  insertingPermission(): void {
    this.router.navigate(['insertorremovepermission']);
  }
}

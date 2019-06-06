import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';

import {Bug, BugJSON} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {Observable} from "rxjs";
import {MatTableDataSource} from '@angular/material/table';
import {MatSort, Sort} from '@angular/material/sort';
import {MatDialog, MatPaginator} from "@angular/material";
import {BugEditComponent} from "../../containers/bug-edit/bug-edit.component";
import {PermissionsService} from "../../../../core/permissions/permissions.service";


@Component({
  selector: 'app-bugs-table-component',
  templateUrl: './bugs-table-component.component.html',
  styleUrls: ['./bugs-table-component.component.css']
})
export class BugsTableComponentComponent implements OnInit {
  displayedColumns: string[] = ["title", "description", "version", "targetDate", "status", "fixedVersion", "severity", "edit"];

  bugs: Bug[];
  bugEdit: Bug = new Bug();

  data = this.loadAllBugs();

  status : string[];
  //
  dataSource = new MatTableDataSource(this.bugs);

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit(){
    //
    this.bugService.loadAllBugs().subscribe(bug => {this.bugs = bug; console.log(this.bugs);
    this.dataSource = new MatTableDataSource<Bug>(this.bugs);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      });

  }

  constructor(private bugService: BugsService, public dialog: MatDialog, public permissionService: PermissionsService) {
   // this.sortedData = this.bugs;
  }

  getRecord(bug: Bug){
    this.bugEdit = bug;

    this.bugService.getStatusLimited(this.bugEdit.status).subscribe(value => this.status = value);
    console.log(this.status);
    for(let per of this.permissionService.getPermissions()){
      if(per === "BUG_CLOSED") this.bugService.getStatusComplete(this.bugEdit.status).subscribe(value => this.status = value);
    }
    console.log(this.bugEdit.status);
    console.log(this.status);
    this.bugEdit.statusList = this.status;

    const dialogRef = this.dialog.open(BugEditComponent, {
      width: '450px',
      data: this.bugEdit
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.ngOnInit();
    });


  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  private loadAllBugs()
  {
    //return this.bugService.loadAllBugs();
    //return this.bugService.loadAllBugs().subscribe(bugs => this.bugs.push(bugs));
    return this.bugService.loadAllBugs().forEach(bug => this.bugs = bug);
  }


}


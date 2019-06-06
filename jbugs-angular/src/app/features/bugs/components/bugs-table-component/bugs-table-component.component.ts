import {Component, OnInit, ViewChild} from '@angular/core';

import {Bug} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {MatDialog, MatPaginator} from "@angular/material";
import {BugEditComponent} from "../../containers/bug-edit/bug-edit.component";
import {BugViewComponent} from "../../containers/bug-view/bug-view.component";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";



@Component({
  selector: 'app-bugs-table-component',
  templateUrl: './bugs-table-component.component.html',
  styleUrls: ['./bugs-table-component.component.css']
})
export class BugsTableComponentComponent implements OnInit {
  displayedColumns: string[] = ["title", "description", "version", "targetDate", "status", "fixedVersion", "severity", "edit"];

  bugs: Bug[];
  bugEdit: Bug = new Bug();

  bugView: Bug = new Bug();
  bugt: Bug = new Bug();
  data = this.loadAllBugs();

  status: string[];
  //
  dataSource = new MatTableDataSource(this.bugs);

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private bugService: BugsService, public dialog: MatDialog, public authService: AuthenticationService) {
    // this.sortedData = this.bugs;
  }

  ngOnInit() {
    //
    this.bugService.loadAllBugs().subscribe(bug => {
      this.bugs = bug;
      console.log(this.bugs);
      this.dataSource = new MatTableDataSource<Bug>(this.bugs);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });

  }

  getRecord(bug: Bug) {
    this.bugEdit = bug;

    this.bugService.getStatusLimited(this.bugEdit.status).subscribe(value => this.status = value);
    console.log(this.status);
    for (let per of this.authService.getPermissions()) {
      if (per === "BUG_CLOSED") this.bugService.getStatusComplete(this.bugEdit.status).subscribe(value => this.status = value);
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

  viewRecord(bug: Bug) {
    this.bugView = bug;
    this.dialog.open(BugViewComponent, {
      width: '450px',
      data: this.bugView
    });
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  private loadAllBugs() {
    //return this.bugService.loadAllBugs();
    //return this.bugService.loadAllBugs().subscribe(bugs => this.bugs.push(bugs));
    return this.bugService.loadAllBugs().forEach(bug => this.bugs = bug);
  }


}


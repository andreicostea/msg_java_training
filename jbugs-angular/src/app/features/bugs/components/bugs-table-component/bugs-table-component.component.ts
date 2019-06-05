import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';

import {Bug, BugJSON} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {Observable} from "rxjs";
import {MatTableDataSource} from '@angular/material/table';
import {MatSort, Sort} from '@angular/material/sort';
import {MatDialog, MatPaginator} from "@angular/material";
import {BugEditComponent} from "../../containers/bug-edit/bug-edit.component";


@Component({
  selector: 'app-bugs-table-component',
  templateUrl: './bugs-table-component.component.html',
  styleUrls: ['./bugs-table-component.component.css']
})
export class BugsTableComponentComponent implements OnInit {
  displayedColumns: string[] = ["title", "description", "version", "targetDate", "status", "fixedVersion", "severity", "edit"];

  //data: Observable<Bug[]> = this.loadAllBugs();
  // bugs: Bug[] = [
  //   {
  //     title: "bug1",
  //     description: "description1",
  //     version: "v1.1",
  //     targetDate: "30-05-2019",
  //     status: "status",
  //     fixedVersion: "v7.2",
  //     severity: "sev"
  //   },
  //   {
  //     title: "bug2",
  //     description: "description2",
  //     version: "v2.1",
  //     targetDate: "30-06-2019",
  //     status: "status",
  //     fixedVersion: "v7.2",
  //     severity: "sev"
  //   }
  // ];
  bugs: Bug[];
  bugEdit: Bug = new Bug();
  bugt: Bug = new Bug();
  data = this.loadAllBugs();
  sortedData: Bug[];
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
    //this.dataSource.sort = this.sort;
  }

  constructor(private bugService: BugsService, public dialog: MatDialog) {
   // this.sortedData = this.bugs;
  }

  getRecord(bug: Bug){
    this.bugEdit = bug;
    //console.log(this.bugEdit.title);
     this.dialog.open(BugEditComponent, {
      width: '450px',
      data: this.bugEdit
    });
    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('The dialog was closed');
    //   this.bugt = result;
    // });


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

  sortData(sort: Sort) {
    const data = this.bugs;
    if (!sort.active || sort.direction === '') {
      this.sortedData = data;
      return;
    }
    this.sortedData = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'title':
          return compare(a.title, b.title, isAsc);
        case 'description':
          return compare(a.description, b.description, isAsc);
        case 'version':
          return compare(a.version, b.version, isAsc);
        case 'targetDate':
          return compare(a.targetDate, b.targetDate, isAsc);
        case 'status':
          return compare(a.status, b.status, isAsc);
        case 'fixedVersion':
          return compare(a.fixedVersion, b.fixedVersion, isAsc);
        case 'severity':
          return compare(a.severity, b.severity, isAsc);
        default:
          return 0;
      }
    });
  }
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);




  //@ViewChild(MatSort, {static: true}) sort: MatSort;


    //this.dataSource.sort = this.sort;

}

import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
@Component({
  selector: 'app-bugs-table-component',
  templateUrl: './bugs-table-component.component.html',
  styleUrls: ['./bugs-table-component.component.css']
})
export class BugsTableComponentComponent implements OnInit {

  constructor() { }

  //@ViewChild(MatSort, {static: true}) sort: MatSort;

  ngOnInit() {
    //this.dataSource.sort = this.sort;
  }

}

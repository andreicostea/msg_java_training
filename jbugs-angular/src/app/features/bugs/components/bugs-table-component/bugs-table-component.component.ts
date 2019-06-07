import {Component, OnInit, ViewChild} from '@angular/core';
import {Bug, BugJSON} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {Observable} from "rxjs";
import {MatTableDataSource} from '@angular/material/table';
import {MatSort, Sort} from '@angular/material/sort';
import {MatDialog, MatPaginator} from "@angular/material";
import {BugEditComponent} from "../../containers/bug-edit/bug-edit.component";
import {BugViewComponent} from "../../containers/bug-view/bug-view.component";
import {PermissionsService} from "../../../../core/permissions/permissions.service";
import * as XLSX from 'xlsx';
import html2canvas from 'html2canvas';
import * as jspdf from 'jspdf';
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

  status : string[];
  //
  dataSource = new MatTableDataSource(this.bugs);
  @ViewChild(MatSort) sort:MatSort;
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
  viewRecord(bug: Bug){
    this.bugView = bug;
    this.dialog.open(BugViewComponent, {
      width: '450px',
      data: this.bugView
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
  public export() {
    const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(this.bugs);
    /* generate workbook and add the worksheet */
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, worksheet, 'Sheet1');
    /* save to file */
    XLSX.writeFile(wb, "Bugs.xlsx");
  }
  public generatePDF()
  {
    var data = document.getElementById('contentToConvert');
    html2canvas(data).then(canvas => {
      // Few necessary setting options
      var imgWidth = 208;
      var pageHeight = 295;
      var imgHeight = canvas.height * imgWidth / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/png')
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)
      pdf.save('Bugspdf.pdf'); // Generated PDF
    });
  }
}



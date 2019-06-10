import {Component, OnInit, ViewChild} from '@angular/core';
import {Bug} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {MatDialog, MatPaginator} from "@angular/material";
import {BugEditComponent} from "../../containers/bug-edit/bug-edit.component";
import {BugViewComponent} from "../../containers/bug-view/bug-view.component";
import * as XLSX from 'xlsx';
import html2canvas from 'html2canvas';
import * as jspdf from 'jspdf';
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
  permissonClosed: boolean = false;
  data = this.loadAllBugs();

  status: string[];
  //
  dataSource = new MatTableDataSource(this.bugs);
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private bugService: BugsService, public dialog: MatDialog, public authenticationService: AuthenticationService) {
    // this.sortedData = this.bugs;
  }

  ngOnInit() {
    //
    this.bugService.loadAllBugs().subscribe(bug => {
      this.bugs = bug;
      this.dataSource = new MatTableDataSource<Bug>(this.bugs);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });

  }


  getRecord(bug: Bug) {
    this.bugEdit = bug;
    console.log(this.bugEdit.status);

    for (let per of this.authenticationService.getPermissions()) {
      if(per === "BUG_CLOSED"){
        this.permissonClosed = true;
      }
    }

    if (this.permissonClosed === true) {

      this.bugService.getStatusComplete(this.bugEdit.status).subscribe(value => {
        this.status = value;
        this.bugEdit.statusList = this.status;

        const dialogRef = this.dialog.open(BugEditComponent, {
          width: '450px',
          data: this.bugEdit
        });
        dialogRef.afterClosed().subscribe(result => {
          console.log('The dialog was closed');
          this.ngOnInit();
        });

      });

    } else {

      this.bugService.getStatusLimited(this.bugEdit.status).subscribe(value => {
        this.status = value;
        this.bugEdit.statusList = this.status;

        const dialogRef = this.dialog.open(BugEditComponent, {
          width: '450px',
          data: this.bugEdit
        });
        dialogRef.afterClosed().subscribe(result => {
          console.log('The dialog was closed');
          this.ngOnInit();
        });

      });

    }

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

  public export() {
    const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(this.bugs);
    /* generate workbook and add the worksheet */
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, worksheet, 'Sheet1');
    /* save to file */
    XLSX.writeFile(wb, "Bugs.xlsx");
  }

  public generatePDF() {
    var data = document.getElementById('contentToConvert');
    html2canvas(data).then(canvas => {
      // Few necessary setting options
      var imgWidth = 208;
      var pageHeight = 295;
      var imgHeight = canvas.height * imgWidth / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/png');
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight);
      pdf.save('Bugspdf.pdf'); // Generated PDF
    });
  }

  private loadAllBugs() {
    //return this.bugService.loadAllBugs();
    //return this.bugService.loadAllBugs().subscribe(bugs => this.bugs.push(bugs));
    return this.bugService.loadAllBugs().forEach(bug => this.bugs = bug);
  }

  showButton(): boolean {
    if (this.authenticationService.getPermissions() === null) return false;
    for (let per of this.authenticationService.getPermissions())
      if (per === "BUG_MANAGEMENT") return true;
    return false;
  }

  showButton2(): boolean {
    if (this.authenticationService.getPermissions() === null) return false;
    for (let per of this.authenticationService.getPermissions()) {
      if (per === "BUG_EXPORT_PDF") return true;
    }
    return false;
  }
}



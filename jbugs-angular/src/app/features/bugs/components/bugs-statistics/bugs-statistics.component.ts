import {Component, OnInit} from '@angular/core';
import {BugsService} from "../../services/bugs.service";

@Component({
  selector: 'app-bugs-statistics',
  templateUrl: './bugs-statistics.component.html',
  styleUrls: ['./bugs-statistics.component.css']
})
export class BugsStatisticsComponent implements OnInit {
  constructor(private bugService: BugsService) {
  }

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };

  public barChartLabels = ['2019'];
  public barChartType = 'bar';
  public barChartLegend = true;
  public barChartData = [
    {data: [41,19, 50, 27, 50], label: 'Bug Open'},
    {data: [41, 19, 50, 27, 50], label: 'Bug Fixed'},
    {data: [41, 19, 50, 27, 50], label: 'Bug Closed'},
    {data: [41, 19, 50, 27, 50], label: 'Bug In Progress'},
    {data: [41, 19, 50, 27, 50], label: 'Bug Info Needed'},
    {data: [41, 19, 50, 27, 50], label: 'Bug Rejected'},
  ]

  ngOnInit() {
    var that = this;
    this.bugService.getStatistics().subscribe(statistics => {
      console.log(statistics)
      that.barChartData = [
        {data: [statistics.newBug,0, 3, 5, 7, 10], label: 'Bug Open'},
        {data: [statistics.fixed,0, 3, 5, 7, 10], label: 'Bug Fixed'},
        {data: [statistics.closed,0, 3, 5, 7, 10], label: 'Bug Closed'},
        {data: [statistics.inProgress,0, 3, 5, 7, 10], label: 'Bug In Progress'},
        {data: [statistics.infoNeeded, 0, 3, 5, 7, 10], label: 'Bug Info Needed'},
        {data: [statistics.rejected,0, 3, 5, 7, 10], label: 'Bug Rejected'},
      ]

    })
  }

  loadStatistics() {
    this.bugService.getStatistics().subscribe(statistics => {
      console.log(statistics)

    })


  }
}

// {closed: [30], label: 'Bug Open'},
// {data: [41, 19, 50, 27, 50], label: 'Bug Fixed'},
// {data: [41, 19, 50, 27, 50], label: 'Bug Closed'},
// {data: [41, 19, 50, 27, 50], label: 'Bug In Progress'},
// {data: [41, 19, 50, 27, 50], label: 'Bug Info Needed'},
// {data: [41, 19, 50, 27, 50], label: 'Bug Rejected'},

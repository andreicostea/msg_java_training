export interface StatisticsJSON {
  newBug:number;
  open: number;
  fixed: number;
  closed: number;
  inProgress: number;
  infoNeeded: number;
  rejected:number;
}


export class Statistics {
  newBug:number;
  open: number;
  fixed: number;
  closed: number;
  inProgress: number;
  infoNeeded: number;
  rejected: number;

  static fromJSON(json: StatisticsJSON): Statistics {
    const termin = new Statistics();
    termin.newBug = json.newBug;
    termin.open = json.open;
    termin.fixed = json.fixed;
    termin.closed = json.closed;
    termin.inProgress = json.inProgress;
    termin.infoNeeded = json.infoNeeded;
    termin.rejected = json.rejected;
    return termin;
  }

  static toJSON(statistic: Statistics): StatisticsJSON {
    return <StatisticsJSON>{
      newBug: statistic.newBug,
      open: statistic.open,
      fixed: statistic.fixed,
      closed: statistic.closed,
      inProgress: statistic.inProgress,
      infoNeeded: statistic.infoNeeded,
      rejected: statistic.rejected
    };
  }

  static createEmpty(): Statistics {
    const statistics = new Statistics();
    return statistics;
  }
}

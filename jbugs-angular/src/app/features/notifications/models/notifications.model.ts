import {BugJSON} from "../../bugs/models/bugs.model";

export interface NotificationsJSON {

  position: number;
  date: number;
  type: string;
  description: string;
}


export class Notifications {
  position: number;
  date: number;
  type: string;
  description: string;

  static fromJSON(json: NotificationsJSON): Notifications {
    const termin = new Notifications();
    termin.position = json.position;
    termin.date = json.date;
    termin.type = json.type;
    termin.description = json.description;
    return termin;
  }

  static toJSON(notification: Notifications): NotificationsJSON {
    return <NotificationsJSON>{
      position: notification.position,
      date: notification.date,
      type: notification.type,
      description:notification.description
    };
  }

  static createEmpty():Notifications {
    const bug = new Notifications();
    return bug;
  }
}

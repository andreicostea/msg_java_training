export class User {
  id: number;
  firstName: string;
  lastName: string;
  userName: string;
  email: string;
  mobileNumber: string;
  roles: string[];
  token: string;
  status: number;

  static fromJSON(json: UserJSON): User {
    const termin = new User();
    termin.id = json.id;
    termin.firstName = json.firstName;
    termin.lastName = json.lastName;
    termin.userName = json.userName;
    termin.email = json.email;
    termin.mobileNumber = json.mobileNumber;
    termin.roles = json.roles;
    termin.token = json.token;
    return termin;
  }
}


export interface UserJSON {
  id: number;
  firstName: string;
  lastName: string;
  userName: string;
  email: string;
  mobileNumber: string;
  roles: string[];
  token: string;
}


export class UserUpdate {
  firstName: string;
  lastName: string;
  emailBeforeUpdate: string;
  email: string;
  mobileNumber: string;
  roles: string[];
  // token: string;
  status: number;

  constructor(firstName: string, lastName: string, emailBeforeUpdate: string, email: string, mobileNumber: string, status: number, roles: string[]) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailBeforeUpdate = emailBeforeUpdate;
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.status = status;
    this.roles = roles;
  }
}

export class UserChangePasswordDTO {
  username: string;
  newPassword: string;

  constructor(username: string, newPassword: string) {
    this.username = username;
    this.newPassword = newPassword;
  }
}

export class Role {
  id: number;
  type: string;
}

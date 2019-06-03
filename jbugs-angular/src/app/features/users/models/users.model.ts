export interface UserJSON {
  firstName: string;
  lastName: string;
  email: string;
  roles: string[];
  token: string;
  mobileNumber: string;
}

export class UserUpdate {
  firstName: string;
  lastName: string;
  emailBeforeUpdate: string;
  email: string;
  mobileNumber: string;
  // roles: string[];
  // token: string;

  constructor(firstName: string, lastName: string, emailBeforeUpdate: string, email: string, mobileNumber: string) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailBeforeUpdate = emailBeforeUpdate;
    this.email = email;
    this.mobileNumber = mobileNumber;
  }
}


export class User {
  firstName: string;
  lastName: string;
  email: string;
  mobileNumber: string;
  roles: string[];
  token: string;


  static fromJSON(json: UserJSON): User {
    const termin = new User();
    termin.firstName = json.firstName;
    termin.lastName = json.lastName;
    termin.email = json.email;
    termin.roles = json.roles;
    termin.token = json.token;
    return termin;
  }

  static toJSON(user: User): UserJSON {
    return <UserJSON>{
      firstName: user.firstName,
      lastName: user.lastName,
      email: user.email,
      roles: user.roles,
      token: user.token
    };
  }

  static createEmpty(): User {
    const user = new User();
    return user;
  }
}

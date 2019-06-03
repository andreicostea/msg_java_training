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

export class Role {
  id : number;
  type : string;
}

export class User {
  id: number;
  firstName: string;
  lastName: string;
  userName: string;
  email: string;
  mobileNumber: string;
  roles: string[];
  token: string;

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

  static toJSON(user: User): UserJSON {
    return <UserJSON>{
      id: user.id,
      firstName: user.firstName,
      lastName: user.lastName,
      userName: user.userName,
      email: user.email,
      roles: user.roles,
      token: user.token,
      mobileNumber: user.mobileNumber,
    };
  }

  static createEmpty(): User {
    const user = new User();
    return user;
  }
}

export interface UserJSON {
  firstName: string;
  lastName: string;
  email: string;
  roles: string[];
}

export class User {
  firstName: string;
  lastName: string;
  email: string;
  roles: string[];

  static fromJSON(json: UserJSON): User {
    const termin = new User();
    termin.firstName = json.firstName;
    termin.lastName = json.lastName;
    termin.email = json.email;
    termin.roles = json.roles;
    return termin;
  }

  static toJSON(user: User): UserJSON {
    return <UserJSON>{
      firstName: user.firstName,
      lastName: user.lastName,
      email: user.email,
      roles: user.roles
    };
  }

  static createEmpty(): User {
    const user = new User();
    return user;
  }
}

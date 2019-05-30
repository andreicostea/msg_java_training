export interface UserWithTokenJSON {
  user: UserJSON;
  token: string;
}

export interface UserJSON {
  email: string;
  username: string;
  permissions: string[];
}

export class User {
  email: string;
  username: string;
  permissions: string[];

  static fromJSON(json: UserJSON): User {
    const termin = new User();
    termin.email = json.email;
    termin.username = json.username;
    termin.permissions = json.permissions;
    return termin;
  }

  static toJSON(user: User): UserJSON {
    return <UserJSON>{
      email: user.email,
      username: user.username,
      permissions: user.permissions
    };
  }

  static createEmpty(): User {
    const user = new User();
    return user;
  }
}

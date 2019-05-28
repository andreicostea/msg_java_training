export interface UserJSON {
  firstName: string;
  lastName: string;
  email: string;
  mobileNumber: string;
}

export class User {
  firstName: string;
  lastName: string;
  email: string;
  mobileNumber: string;

  static fromJSON(json: UserJSON): User {
    const user = new User();
    user.firstName = json.firstName;
    user.lastName = json.lastName;
    user.email = json.email;
    user.mobileNumber = json.mobileNumber;
    return user;
  }

  static toJSON(user: User): UserJSON {
    return <UserJSON>{
      firstName: user.firstName,
      lastName: user.lastName,
      email: user.email,
      mobileNumber: user.mobileNumber
    };
  }

  static createEmpty(): User {
    const user = new User();
    return user;
  }
}

export interface UserJSON {
  firstName: string;
  lastName: string;
  email: string;
  mobileNumber: string;
}

export class User {
  private _firstName: string;
  private _lastName: string;
  private _email: string;
  private _mobileNumber: string;

  get firstName(): string {
    return this._firstName;
  }

  set firstName(value: string) {
    this._firstName = value;
  }

  get lastName(): string {
    return this._lastName;
  }

  set lastName(value: string) {
    this._lastName = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get mobileNumber(): string {
    return this._mobileNumber;
  }

  set mobileNumber(value: string) {
    this._mobileNumber = value;
  }

  static fromJSON(json: UserJSON): User {
    const user = new User();
    user._firstName = json.firstName;
    user._lastName = json.lastName;
    user._email = json.email;
    user._mobileNumber = json.mobileNumber;
    return user;
  }

  static toJSON(user: User): UserJSON {
    return <UserJSON>{
      firstName: user._firstName,
      lastName: user._lastName,
      email: user._email,
      mobileNumber: user._mobileNumber
    };
  }

  static createEmpty(): User {
    const user = new User();
    return user;
  }
}

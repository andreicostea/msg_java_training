export interface loginInputJSON {
  username: string;
  password: string;


}

export class LoginInput {
  username: string;
  password: string;


  static fromJSON(json: loginInputJSON): LoginInput {
    const termin = new LoginInput();
    termin.username = json.username;
    termin.password = json.password;
    return termin;
  }

  static toJSON(loginInput: LoginInput): loginInputJSON {
    return <loginInputJSON>{
      username: loginInput.username,
      password: loginInput.password,


    };
  }

  static createEmpty(): LoginInput {
    const loginInput = new LoginInput();
    return loginInput;
  }
}

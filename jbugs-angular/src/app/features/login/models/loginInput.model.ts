export interface loginInputJSON {
  email: string;
  password: string;
  jwt:string;

}

export class LoginInput {
  email: string;
  password: string;
  jwt:string;


  static fromJSON(json: loginInputJSON): LoginInput {
    const termin = new LoginInput();
    termin.email = json.email;
    termin.password = json.password;
    termin.jwt = json.jwt;
    return termin;
  }

  static toJSON(loginInput: LoginInput): loginInputJSON {
    return <loginInputJSON>{
      email: loginInput.email,
      password: loginInput.password,
      jwt: loginInput.jwt

    };
  }

  static createEmpty(): LoginInput {
    const loginInput = new LoginInput();
    return loginInput;
  }
}

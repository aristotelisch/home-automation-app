export class User {
  id: number;
  name: string;
  isAdmin: false;

  personname: string;
  surname: string;
  username: string;
  email: string;
  password: string;
  personrole: string;

  constructor (name, isAdmin) {
    this.name = name;
    this.isAdmin = isAdmin;
  }
}

export class User {
  name: string;
  email: string;
  isAdmin: false;

  constructor (name, isAdmin) {
    this.name = name;
    this.isAdmin = isAdmin;
  }
}

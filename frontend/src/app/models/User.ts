export class User {
  id: number;
  name: string;
  email: string;
  isAdmin: false;

  constructor (name, isAdmin) {
    this.name = name;
    this.isAdmin = isAdmin;
  }
}

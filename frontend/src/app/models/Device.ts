export class Device {

  constructor(id: number, name: string, status: boolean, type: string, information: string){
    this.id=id;
    this.name=name;
    this.status=status;
    this.type=type;
    this.information=information;
  }

  id: number;
  name: string;
  type: string;
  status: boolean;
  information: string;
}


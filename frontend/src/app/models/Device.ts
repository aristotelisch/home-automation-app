export class Device {

  constructor(id: number, name: string, status: boolean, type: string, information: string, roomId: number){
    this.id=id;
    this.name=name;
    this.status=status;
    this.type=type;
    this.information=information;
    this.roomId=roomId;
  }

  id: number;
  name: string;
  type: string;
  status: boolean;
  information: string;
  roomId: number;
}


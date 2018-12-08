export class Room {
  id: number;
  name: string;
  //description: string;
  image: string;

  constructor(id: number, name: string, image: string){
    this.id=id;
    this.name=name;
    this.image=image;
  }

  public getRoomId(): number{
    return this.id;
  }
}

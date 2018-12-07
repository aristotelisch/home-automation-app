export class Room {
  id: number;
  name: string;
  description: string;
  image: string;

  public getRoomId(): number{
    return this.id;
  }
}

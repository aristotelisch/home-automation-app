package eu.codingschool.black.homeautomation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Device {
  @Id
  @GeneratedValue
  private long deviceid;

  private String devicename;
  private String type;
  private boolean status;
  private String information;

  @Transient
  private long roomId;

  @Transient
  private String roomName;

  @ManyToOne
  //@JsonManagedReference            // serializes normally
  @JsonIgnore           // we don't want to return the Room along with the Device
  @JoinColumn(name = "room")
  private Room room;

  public Device() {
  }

  public Device (String devicename, String type, boolean status, String information) {
    this.devicename = devicename;
    this.type = type;
    this.status = status;
    this.information = information;
  }

  public Device (String devicename, String type, boolean status, String information, Room room) {
    this(devicename, type, status, information);
    this.room = room;
  }

  public Device (Device device, Room room){
    this(device.devicename, device.type, device.status, device.information);
    this.room = room;
    this.deviceid=device.deviceid;
  }

  public long getId () {
    return deviceid;
  }

  public void setId (long id) {
    this.deviceid = id;
  }

  public String getName () {
    return devicename;
  }

  public void setName (String name) {
    this.devicename = name;
  }

  public String getType () {
    return type;
  }

  public void setType (String type) {
    this.type = type;
  }

  public boolean isStatus () {
    return status;
  }

  public void setStatus (boolean status) {
    this.status = status;
  }

  public String getInformation () {
    return information;
  }

  public void setInformation (String information) {
    this.information = information;
  }

  public Room getRoom() {return room;}

  public void setRoom(Room room) {this.room = room;}

  public long getRoomId() {return this.roomId;}

  public String getRoomName() {return this.room.getName();}

  public void setRoomName(String roomName) {this.roomName = roomName; }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }

  @Override
  public String toString() {
    return this.deviceid + " " +this.devicename +"           "+ this.roomId + " "+ this.roomName +"               RoomId by Room " + this.room.getId();
  }
}

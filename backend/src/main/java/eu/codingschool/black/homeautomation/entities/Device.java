package eu.codingschool.black.homeautomation.entities;

import javax.persistence.*;

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

  @ManyToOne
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

  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }

  @Override
  public String toString() {
    return this.deviceid + " " +this.devicename;
  }
}

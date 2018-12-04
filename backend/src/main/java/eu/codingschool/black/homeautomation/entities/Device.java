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

  @Override
  public String toString() {
    return this.deviceid + " " +this.devicename;
  }
}

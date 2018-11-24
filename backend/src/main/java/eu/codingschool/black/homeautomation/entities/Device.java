package eu.codingschool.black.homeautomation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device {
  @Id
  @GeneratedValue
  private long id;

  private String name;
  private String type;
  private boolean status;
  private String information;


  public long getId () {
    return id;
  }

  public void setId (long id) {
    this.id = id;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
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
    return this.id + " " +this.name;
  }
}

package eu.codingschool.black.homeautomation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
  @Id
  @GeneratedValue
  private long id;

  private String name;

  @Column(name = "image", nullable = false, columnDefinition = "varchar(255) default 'default_room.jpg'")
  private String image;

  public Room () {
  }

  public String getImage () {
    return image;
  }

  public void setImage (String image) {
    this.image = image;
  }

  public Room (String name, String image) {
    this.name = name;
    this.image = image;
  }



  @OneToMany(mappedBy = "room")
  //@JsonBackReference            // omits serialization
  private List<Device> devices;

  public long getId() {
    return id;
  }

  public List<Device> getDevices() { return this.devices; }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.id + " " +this.name;
  }
}

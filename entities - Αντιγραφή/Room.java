package eu.codingschool.black.homeautomation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Room {
  @Id
  @GeneratedValue
  private long id;

  private String name;


  @OneToMany(mappedBy = "room")
  private List<Device> devices;
  public long getId() {
    return id;
  }

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

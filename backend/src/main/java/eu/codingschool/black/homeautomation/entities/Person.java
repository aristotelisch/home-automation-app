package eu.codingschool.black.homeautomation.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long personid;
    private String personname;
    private String surname;
    private String email;
    private String password;
    private String role;
    @ManyToMany
    @JoinTable(name = "persondevice", joinColumns = @JoinColumn(name = "personid", referencedColumnName = "personid"), inverseJoinColumns = @JoinColumn(name = "deviceid", referencedColumnName = "deviceid"))
    private Set<Device> device;

    public Person(long personid, String personname, String surname, String email, String password, String role) {
        this.personid = personid;
        this.personname = personname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public long getId() {
        return personid;
    }

    public void setId(long id) {
        this.personid = personid;
    }

    public String getName() {
        return personname;
    }

    public void setName(String name) {
        this.personname = personname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}

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
    @ManyToOne
    @JoinColumn(name = "personrole")
    protected PersonRole personrole;
    @ManyToMany
    @JoinTable(name = "persondevice", joinColumns = @JoinColumn(name = "personid", referencedColumnName = "personid"), inverseJoinColumns = @JoinColumn(name = "deviceid", referencedColumnName = "deviceid"))
    private Set<Device> device;

    public Person(long personid, String personname, String surname, String email, String password, PersonRole personrole) {
        this.personid = personid;
        this.personname = personname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.personrole = personrole;
    }


    public long getPersonid() {
        return personid;
    }

    public void setPersonid(long personid) {
        this.personid = personid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public Set<Device> getDevice() {
        return device;
    }

    public void setDevice(Set<Device> device) {
        this.device = device;
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

    public PersonRole getPersonrole() {
        return personrole;
    }

    public void setPersonrole(PersonRole personrole) {
        this.personrole = personrole;
    }



}

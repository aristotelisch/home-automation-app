package eu.codingschool.black.homeautomation.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long personid;
    private String personname;

    @Column(nullable = false, unique = true)
    private String username;
    private String surname;
    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "personrole")
    protected PersonRole personrole;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "persondevice", joinColumns = @JoinColumn(name = "personid", referencedColumnName = "personid"), inverseJoinColumns = @JoinColumn(name = "deviceid", referencedColumnName = "deviceid"))
    private Set<Device> device;

    public Person() {}

    public Person(String personname, String surname, String email, String password, PersonRole personrole) {
        this.personname = personname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.personrole = personrole;
    }

    public Person(long personid, String personname, String surname, String email, String password, PersonRole personrole) {
        this(personname, surname, email, password, personrole);
        this.personid = personid;
    }

    public long getPersonid () {
        return personid;
    }

    public void setPersonid (long personid) {
        this.personid = personid;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public Set<Device> getDevice () {
        return device;
    }

    public void setDevice (Set<Device> device) {
        this.device = device;
    }



    public long getId() {
        return personid;
    }

    public void setId(long id) {
        this.personid = personid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String name) {
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

//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    List<GrantedAuthority> authorities = new ArrayList<> ();
//    authorities.add(new SimpleGrantedAuthority (personrole.getRolename()));
//    return authorities;
//  }


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

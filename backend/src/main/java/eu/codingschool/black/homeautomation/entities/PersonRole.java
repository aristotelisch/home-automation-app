package eu.codingschool.black.homeautomation.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonRole {
    @Id
    @GeneratedValue
    private long roleid;
    private String rolename;

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public PersonRole(long roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }
}

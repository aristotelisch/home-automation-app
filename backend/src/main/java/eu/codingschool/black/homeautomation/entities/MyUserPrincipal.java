package eu.codingschool.black.homeautomation.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserPrincipal implements UserDetails {
  private Person user;

  public MyUserPrincipal(Person user) {
    this.user = user;
  }

  @Override
  @JsonManagedReference
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<> ();
    Person u = user;
    PersonRole pRole = u.getPersonrole();
    authorities.add(new SimpleGrantedAuthority (user.getPersonrole ().getRolename ()));
    return authorities;
  }

  @Override
  public String getPassword () {
    return this.user.getPassword ();
  }

  @Override
  public String getUsername () {
    return this.user.getUsername ();
  }

  @Override
  public boolean isAccountNonExpired () {
    return true;
  }

  @Override
  public boolean isAccountNonLocked () {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired () {
    return true;
  }

  @Override
  public boolean isEnabled () {
    return true;
  }
  //...
}

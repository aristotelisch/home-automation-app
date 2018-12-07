package eu.codingschool.black.homeautomation.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUserPrincipal implements UserDetails {
  private Person user;

  public MyUserPrincipal(Person user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities () {
    return null;
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

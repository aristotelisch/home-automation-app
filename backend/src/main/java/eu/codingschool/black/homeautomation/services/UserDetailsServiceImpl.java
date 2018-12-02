package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private PersonService personService;

    @Override
    public UserDetails loadUserByUsername(String personname) throws UsernameNotFoundException {
        Person person = personService.findByPersonname(personname);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(person!=null) {
            grantedAuthorities.add(new SimpleGrantedAuthority(person.getPersonrole().toString()));
        }
        return new org.springframework.security.core.userdetails.User(person.getPersonname(), person.getPassword(), grantedAuthorities);
    }
}
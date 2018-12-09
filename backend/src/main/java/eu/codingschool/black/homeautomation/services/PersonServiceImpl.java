package eu.codingschool.black.homeautomation.services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eu.codingschool.black.homeautomation.entities.MyUserPrincipal;
import eu.codingschool.black.homeautomation.entities.PersonRole;
import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.repositories.PersonRepository;
import eu.codingschool.black.homeautomation.repositories.PersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonRoleRepository personRoleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) {
        Person user = personRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException (username);
        }
        return new MyUserPrincipal (user);
    }


    @Override
    public Person findByPersonname(String personname) {
        return personRepository.findByPersonname(personname);
    }

    @Override
    public List<Person> findByPersonnameContaining(String searchterm) {
        return personRepository.findByPersonnameContaining(searchterm);
    }

    @Override
    public Person findByUsername (String username) {
        return personRepository.findByUsername(username);
    }

    @Override
    public void save(Person person) {
        //System.out.println(person.getPersonrole().getRolename() + "         SHIIIIIIIIIIIIIIIIIIT          " + person.getPersonrole());
        //encrypt the user password
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRoleRepository.save(person.getPersonrole());  // inserts mockRole                       /* object references an unsaved transient instance - save the transient instance before flushing *** */
        personRepository.save(person);
    }

    // @Override
    // public void deleteMockRole(){personRoleRepository.deleteMockRole();}


    @Override
    public Person findByPersonid(long id) {
        return personRepository.findByPersonid(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findByPersonrole(PersonRole role) {
        return personRepository.findByPersonrole(role);
    }

    @Override
    public void deleteById(long id) {personRepository.deleteById(id);}


}

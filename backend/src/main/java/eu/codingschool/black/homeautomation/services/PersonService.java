package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.entities.PersonRole;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PersonService extends UserDetailsService {
    Person findByPersonname(String personname);
    List<Person> findByPersonnameContaining(String searchterm);
    Person findByUsername(String username);
    void save(Person person);

//    void deleteMockRole();

    Person findByPersonid(long id);
    List<Person> findAll();
    List<Person> findByPersonrole(PersonRole role);
    void deleteById(long id);

}

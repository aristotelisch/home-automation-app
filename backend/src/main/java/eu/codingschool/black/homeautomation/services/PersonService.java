package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.entities.PersonRole;

import java.util.List;

public interface PersonService {
    Person findByPersonname(String personname);
    List<Person> findByPersonnameContaining(String searchterm);
    void save(Person person);
    Person findByPersonid(long id);
    List<Person> findAll();
    List<Person> findByPersonrole(PersonRole role);

}

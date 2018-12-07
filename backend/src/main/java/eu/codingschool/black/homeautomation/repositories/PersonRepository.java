package eu.codingschool.black.homeautomation.repositories;


import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.entities.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long>{
    public Person findByUsername(String username);
    public Person findByPersonname(String personname);
    public List<Person> findByPersonnameContaining(String searchterm);
    public Person findByPersonid(long id);
    public List<Person> findByPersonrole(PersonRole rolename);
}

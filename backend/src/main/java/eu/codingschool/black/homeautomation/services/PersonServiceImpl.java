package eu.codingschool.black.homeautomation.services;

import java.util.List;
import eu.codingschool.black.homeautomation.entities.PersonRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.repositories.PersonRepository;
import eu.codingschool.black.homeautomation.repositories.PersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonRoleRepository personRoleRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Person findByPersonname(String personname) {
        return personRepository.findByPersonname(personname);
    }

    @Override
    public List<Person> findByPersonnameContaining(String searchterm) {
        return personRepository.findByPersonnameContaining(searchterm);
    }

    @Override
    public void save(Person person) {
        //encrypt the user password
//        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
//        //Set the user's personrole as a simple user
//        person.setPersonrole(personRoleRepository.findByRolename("PERSON"));
        personRepository.save(person);
    }

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

    @Autowired
    private PersonRepository repository;


}

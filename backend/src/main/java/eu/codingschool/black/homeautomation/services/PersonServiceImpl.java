package eu.codingschool.black.homeautomation.services;

import java.security.Principal;
import java.util.List;

import eu.codingschool.black.homeautomation.entities.MyUserPrincipal;
import eu.codingschool.black.homeautomation.entities.PersonRole;
import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.repositories.PersonRepository;
import eu.codingschool.black.homeautomation.repositories.PersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(Person person) {
        //encrypt the user password
        person.setPassword(passwordEncoder.encode(person.getPassword()));

        // Set the user's personrole as a simple user
        person.setPersonrole(personRoleRepository.findByRolename("USER"));
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

    @Override
    public void deleteById(long id) {personRepository.deleteById(id);}


}

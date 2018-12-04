package eu.codingschool.black.homeautomation.controllers;

import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.repositories.PersonRepository;
import eu.codingschool.black.homeautomation.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/persons")
    public Collection<Person> getPersons() {
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Controller for Person creation.
     * Called by admin
     *
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/persons")          // temp url address ***
    public Collection<Person> addPerson(@RequestBody Person person){
        service.save(person);
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/persons/{id}")           // temp url address ***
    public Collection<Person> removePerson(@PathVariable("id") long id){
        service.deleteById(id);
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * The PutController is a duplicate of the PostController.
     * Only in case we need to differentiate them in the future.
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/persons")
    public Collection<Person> updatePerson(@RequestBody Person person){
        service.save(person);
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}

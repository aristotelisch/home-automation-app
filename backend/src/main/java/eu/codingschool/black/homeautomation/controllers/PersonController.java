package eu.codingschool.black.homeautomation.controllers;

import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/persons")
    public Collection<Person> getPersons() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}

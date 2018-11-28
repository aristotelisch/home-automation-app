package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
}

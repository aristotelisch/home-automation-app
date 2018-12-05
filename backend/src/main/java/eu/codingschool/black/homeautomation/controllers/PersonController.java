package eu.codingschool.black.homeautomation.controllers;

import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.repositories.PersonRepository;
import eu.codingschool.black.homeautomation.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/persons")
    public Collection<Person> getPersons() {
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @RequestMapping("/login")
    public boolean login(@RequestBody Person user) {
        return user.getUserName ().equals("user") && user.getPassword().equals("password");
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }
}

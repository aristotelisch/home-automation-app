package eu.codingschool.black.homeautomation.controllers;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.entities.PersonRole;
import eu.codingschool.black.homeautomation.entities.Room;
import eu.codingschool.black.homeautomation.repositories.PersonRoleRepository;
import eu.codingschool.black.homeautomation.services.DeviceService;
import eu.codingschool.black.homeautomation.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private PersonRoleRepository personRoleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/persons")
    public Collection<Person> getPersons() {
        return StreamSupport.stream(personService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @RequestMapping("/login")
    public boolean login(@RequestBody Person user) {
        UserDetails authUser = personService.loadUserByUsername ((user.getUsername ()));
        if (authUser != null) {
            if (passwordEncoder.matches(user.getPassword (), authUser.getPassword ())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @GetMapping("/users")
    public Collection<Person> getUsers() {
        return StreamSupport.stream (personService.findAll ().spliterator (), false)
                .collect(Collectors.toList());
    }


    @GetMapping("/users/{username}/devices")
    public Collection<Device> getUsers(@PathVariable("username") String username) {
        Person user = personService.findByUsername (username);
        List<Device> devices = StreamSupport.stream (user.getDevice ().spliterator (), false)
                .collect(Collectors.toList());

        return  devices;
    }

    @GetMapping("/users/{username}/rooms")
    public Collection<Room> getRooms(@PathVariable("username") String username) {
        Set<Room> rooms = new HashSet<>();

        Person user = personService.findByUsername (username);

        deviceService.findRooms()
        List<Device> devices = StreamSupport.stream (user.getDevice ().spliterator (), false)
                .collect(Collectors.toList());

        return  devices;
    }

    @PostMapping("/users")
    public Collection<Person> addDevice(@RequestBody Person person) {
        personService.save (person);
        return StreamSupport.stream (personService.findAll ().spliterator (), false)
                .collect (Collectors.toList ());
    }

    @DeleteMapping("/users/{id}")
    public Collection<Person> removeDevice(@PathVariable("id") long id){
        personService.deleteById(id);
        return StreamSupport.stream(personService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PutMapping("/users")
    public Collection<Person> updateDevice(@RequestBody Person person){
        System.out.println(person);
        if (person.getPassword ().equals("")) {
            String pass = personService.findByUsername(person.getUsername ()).getPassword ();
            person.setPassword (pass);
        }
        personService.save(person);
        return StreamSupport.stream(personService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Person person) {
        try {
            if (person != null) {
                PersonRole userRole = personRoleRepository.findByRolename ("USER");
                person.setPersonrole (userRole);
                personService.save (person);
                return true;
            }
        } catch (NullPointerException ex) {
            return false;
        }
        return false;
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return authentication;
    }
}

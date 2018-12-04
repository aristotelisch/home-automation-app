package eu.codingschool.black.homeautomation.controllers;

import eu.codingschool.black.homeautomation.entities.Room;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.repositories.RoomRepository;
import eu.codingschool.black.homeautomation.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
public class RoomController {

    @Autowired
    private RoomService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/rooms")
    public Collection<Room> getRooms() {
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Controller for Room creation.
     * Called by admin
     *
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/rooms")          // temp url address ***
    public Collection<Room> addRoom(@RequestBody Room room){
        service.save(room);
        return StreamSupport.stream(service.findAll().spliterator(), false)
                    .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/rooms/{id}")           // temp url address ***
    public Collection<Room> removeRoom(@PathVariable("id") long id){
        service.deleteById(id);
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * The PutController is a duplicate of the PostController.
     * Only in case we need to differentiate them in the future.
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/rooms")
    public Collection<Room> updateRoom(@RequestBody Room room){
        service.save(room);
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Controller for returning all Rooms of one Person/User by personId
     */
}

package eu.codingschool.black.homeautomation.controllers;

import eu.codingschool.black.homeautomation.entities.Room;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.repositories.RoomRepository;
import eu.codingschool.black.homeautomation.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

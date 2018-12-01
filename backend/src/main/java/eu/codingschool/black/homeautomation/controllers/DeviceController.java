package eu.codingschool.black.homeautomation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
public class DeviceController {

    @Autowired
    private DeviceService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/devices")
    public Collection<Device> getDevices() {
        return StreamSupport.stream(service.findAll().spliterator(), false)
               .collect(Collectors.toList());
    }

//    @PostMapping("/devices/add")
//    public Collection<Device> addDevice(@ModelAttribute("device") Device device){
//        return
//
//                StreamSupport.stream(Collection.add(service.save(device)).spliterator(), false)
//                .collect(Collectors.toList());
//    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/devices/add")
    /**
     * If admin enters invalid input (string instead of int, int instead of boolean, etc), program crashes.
     * 1st choice: Implementing a better parsing method, failproof against bad data.
     * 2nd choice: If we return null object, frontend should display error message of invalid argument.
     */
    public Device addDevice(@RequestBody String payload){
        System.out.println(payload);
        try {
            Device device = new ObjectMapper().readValue(payload, Device.class);
            System.out.println(device);
            return service.save(device);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
            // System.exit(-33);
        }
        // return null;
    }
}



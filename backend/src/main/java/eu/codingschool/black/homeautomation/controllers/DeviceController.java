package eu.codingschool.black.homeautomation.controllers;
import com.fasterxml.jackson.databind.JsonNode;
import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.services.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @PostMapping("/devices")
    /**
     * Implemented direct mapping to Device bellow.
     * Have not implemented any kind of checking on the Device input. ***
     */
    public Collection<Device> addDevice(@RequestBody Device device) {
        service.save(device, device.getRoomId());
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/devices/{id}")
    public Collection<Device> removeDevice(@PathVariable("id") long id){
        service.deleteById(id);
        //return "The device with Id: " + id + ", has been deleted."; // check if actually deleted by trying to find it afterwards ???
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * The PutController is a duplicate of the PostController.
     * Only in case we need to differentiate them in the future.
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/devices")
    public Collection<Device> updateDevice(@RequestBody Device device){
        System.out.println(device);
        service.save(device, device.getRoomId());
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}



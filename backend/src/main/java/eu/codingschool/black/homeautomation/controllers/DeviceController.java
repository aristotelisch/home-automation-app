package eu.codingschool.black.homeautomation.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.entities.DeviceStatus;
import eu.codingschool.black.homeautomation.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DeviceController {

  @Autowired
  private DeviceService service;

  @GetMapping("/devices")
  public Collection<Device> getDevices () {
    return StreamSupport.stream (service.findAll ().spliterator (), false)
            .collect (Collectors.toList ());
  }

//    @PostMapping("/devices/add")
//    public Collection<Device> addDevice(@ModelAttribute("device") Device device){
//        return
//
//                StreamSupport.stream(Collection.add(service.save(device)).spliterator(), false)
//                .collect(Collectors.toList());
//    }

    @PostMapping("/devices")
    /**
     * Implemented direct mapping to Device bellow.
     * Have not implemented any kind of checking on the Device input. ***
     */
    public Collection<Device> addDevice(@RequestBody Device device) {
        if (Objects.isNull(device.getRoomId())) return null;
        service.save(device, device.getRoomId());
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }



  @GetMapping("/devices/{id}/status/{statusVar}")
  public Device updateSignleDevice (@PathVariable("id") long id, @PathVariable("statusVar") Boolean statusVar) {
    Device device = service.findById (id);
    device.setStatus (statusVar);
    service.save (device);
    return device;
  }

  @DeleteMapping("/devices/{id}")
  public Collection<Device> removeDevice (@PathVariable("id") long id) {
    service.deleteById (id);
    //return "The device with Id: " + id + ", has been deleted."; // check if actually deleted by trying to find it afterwards ???
    return StreamSupport.stream (service.findAll ().spliterator (), false)
            .collect (Collectors.toList ());
  }


  // return;

    /**
     * The PutController is a duplicate of the PostController.
     * Only in case we need to differentiate them in the future.
     */
    @PutMapping("/devices")
    public Collection<Device> updateDevice(@RequestBody Device device){
//        System.out.println(device);
        service.save(device, device.getRoomId());
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}



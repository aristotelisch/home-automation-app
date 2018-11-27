package eu.codingschool.black.homeautomation.controllers;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.services.DeviceService;
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
public class DeviceController {

  @Autowired
  private DeviceService service;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/devices")
  public Collection<Device> getDevices() {
    return StreamSupport.stream(service.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }
}



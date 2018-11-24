package eu.codingschool.black.homeautomation.controllers;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
  private DeviceRepository repository;

  @GetMapping("/devices")
  public Collection<Device> getDevices() {
    return StreamSupport.stream(repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }
}



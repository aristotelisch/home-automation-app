package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Device;

import java.util.List;

public interface DeviceService {
    List<Device> findAll();
    Device save(Device device);
}

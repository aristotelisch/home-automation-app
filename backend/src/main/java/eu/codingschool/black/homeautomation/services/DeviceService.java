package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<Device> findAll();
    Device findById(long id);
    Device save(Device device, long roomId);
    Device save(Device device);
    void deleteById(long id);
}

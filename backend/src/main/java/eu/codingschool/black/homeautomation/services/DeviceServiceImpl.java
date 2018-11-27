package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Override
    public List<Device> findAll(){return repository.findAll();}
}

package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Autowired
    private RoomService roomService;

    @Override
    public List<Device> findAll(){return repository.findAll();}

    public Device save(Device device){return repository.save(device);}

    public Device save(Device device, long roomId){
        return repository.save(new Device(device, roomService.findById(roomId)));
    }

    public void deleteById(long id){repository.deleteById(id);}
}

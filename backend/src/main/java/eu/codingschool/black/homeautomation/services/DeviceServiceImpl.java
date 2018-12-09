package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.entities.Room;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Autowired
    private RoomService roomService;

    @Autowired
    EntityManager em;

    @Override
    public List<Device>  findAll(){
        List<Device> deviceList = repository.findAll();
        for (Device device : deviceList) {
            long roomId = device.getRoom().getId();
            device.setRoomId(roomId);
            Room tempRoom = roomService.findById(roomId);
            String roomName = tempRoom.getName();
            device.setRoomName(roomName);
        }

        return deviceList;
    }

    public Device save(Device device){
        System.out.println("Save without roomID");
        return repository.save(device);
    }

    public Device save(Device device, long roomId){
        System.out.println("Save with roomID");
        return repository.save(new Device(device, roomService.findById(roomId)));
    }

    public void deleteById(long id){
        repository.deletePersonDevice(id);
        repository.deleteById(id);
    }
}

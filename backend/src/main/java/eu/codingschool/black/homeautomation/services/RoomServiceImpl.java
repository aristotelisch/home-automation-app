package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.entities.Room;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private DeviceService deviceService;

    @Override
    public List<Room> findAll(){return roomRepository.findAll();}

    @Override
    public Room findById(long id){return roomRepository.findById(id).orElse(null);}

    @Override
    public Room save (Room room) {
        return roomRepository.save (room);
    }

    @Override
    public void deleteById (long id) {
        List<Device> devices = deviceService.findAll();
        List<Device> devicesInRoom = new ArrayList<>();
        for (Device device : devices) {
            if (device.getRoomId() == id) devicesInRoom.add(device);
        }
        for (Device device : devicesInRoom) deviceService.deleteById(device.getId());
        roomRepository.deleteById(id);
    }
}

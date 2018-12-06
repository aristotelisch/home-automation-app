package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Room;
import eu.codingschool.black.homeautomation.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository repository;

    @Override
    public List<Room> findAll(){return repository.findAll();}

    @Override
    public Room findById(long id){return repository.findById(id).orElse(null);}

    @Override
    public Room save (Room room) {
        return repository.save (room);
    }

    @Override
    public void deleteById (long id) {repository.deleteById(id); }
}

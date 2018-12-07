package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> findAll();

    Room findById(long id);

    Room save(Room room);

    void deleteById(long id);
}

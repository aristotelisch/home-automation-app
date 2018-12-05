package eu.codingschool.black.homeautomation.services;

import eu.codingschool.black.homeautomation.entities.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room save(Room room);
    void deleteById(long id);
}

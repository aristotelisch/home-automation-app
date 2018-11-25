package eu.codingschool.black.homeautomation.repositories;

import java.util.List;

import eu.codingschool.black.homeautomation.entities.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoomRepository extends CrudRepository<Room, Long> {

}

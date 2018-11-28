package eu.codingschool.black.homeautomation.repositories;


import eu.codingschool.black.homeautomation.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoomRepository extends JpaRepository<Room, Long>{

}

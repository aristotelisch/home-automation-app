package eu.codingschool.black.homeautomation.repositories;


import eu.codingschool.black.homeautomation.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeviceRepository extends JpaRepository<Device, Long>{

}

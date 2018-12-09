package eu.codingschool.black.homeautomation.repositories;


import eu.codingschool.black.homeautomation.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
public interface DeviceRepository extends JpaRepository<Device, Long>{

    /**
     * Native SQL query ***
     */
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "delete from persondevice where deviceid = :id")
    void deletePersonDevice(@Param("id") long id);

//    @Query
//    void deleteById(long id);
}

package eu.codingschool.black.homeautomation.repositories;


import eu.codingschool.black.homeautomation.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long>{
}

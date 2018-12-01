package eu.codingschool.black.homeautomation.repositories;

import eu.codingschool.black.homeautomation.entities.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("PersonRoleRepository")
    public interface PersonRoleRepository extends JpaRepository<PersonRole, Integer> {
        PersonRole findByRolename(String rolename);

    }


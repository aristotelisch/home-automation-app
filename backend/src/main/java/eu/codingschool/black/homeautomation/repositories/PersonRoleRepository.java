package eu.codingschool.black.homeautomation.repositories;

import eu.codingschool.black.homeautomation.entities.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("PersonRoleRepository")
    public interface PersonRoleRepository extends JpaRepository<PersonRole, Integer> {
        PersonRole findFirstByRolename(String rolename);

        ///void save(PersonRole personRole, int temp);

//        @Transactional
//        void deleteByRolename(String roleName);

        @Modifying(clearAutomatically = true)
        @Transactional
        @Query(nativeQuery = true, value = "delete from person_role where roleid = (select max(roleid))")
        void deleteMockRole();
    }


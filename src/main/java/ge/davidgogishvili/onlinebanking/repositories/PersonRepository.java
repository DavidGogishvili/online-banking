package ge.davidgogishvili.onlinebanking.repositories;

import ge.davidgogishvili.onlinebanking.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository <Person, Integer> {

    @Query("select p from Person p where p.firstName like :firstName and p.lastName like :lastName and p.personalNumber like :personalNumber")
    List<Person> findPersons(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("personalNumber") String personalNumber);



}




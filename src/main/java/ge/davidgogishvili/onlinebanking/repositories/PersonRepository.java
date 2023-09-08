package ge.davidgogishvili.onlinebanking.repositories;

import ge.davidgogishvili.onlinebanking.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//თითოეული ცხრილისთვის კეთდება 1 რეპოზიტორი და თითოეული რეპოზიტორისთვის კეთდება 1 ენტიტი თუ იმ ცხრილთან მუშაობა გვჭირდება (ჩანაწერის შექმნა, ძებნა, წაშლა ან რამე სხვა ქმედება)
//უნდა გადავაკეთო ისე, რომ ცოტა უფრო ზოგადი და მოქნილი იყოს პიროვნებების ძებნა
// იმიტომ უწერია პერსონის მერე ინტეჯერი, რომ პრაიმარი კი (ბაზაში, პერსონ ცხრილის) არის ინტეჯერ ტიპის
public interface PersonRepository extends JpaRepository <Person, Integer>, JpaSpecificationExecutor <Person> {



//    @Query("select p from Person p where 1=1 and p.firstName like :firstName and p.lastName like :lastName and p.personalNumber like :personalNumber")
//    List<Person> findPersons(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("personalNumber") String personalNumber);


     Page<Person> findAll(Specification<Person> o, Pageable pageable);


}


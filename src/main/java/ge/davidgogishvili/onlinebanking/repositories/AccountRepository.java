package ge.davidgogishvili.onlinebanking.repositories;

import ge.davidgogishvili.onlinebanking.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//თითოეული ცხრილისთვის კეთდება 1 რეპოზიტორი და თითოეული რეპოზიტორისთვის კეთდება 1 ენტიტი თუ იმ ცხრილთან მუშაობა გვჭირდება (ჩანაწერის შექმნა, ძებნა, წაშლა ან რამე სხვა ქმედება)

public interface AccountRepository extends JpaRepository <Account, Integer> {

    List<Account> findAllByPersonId(

            Integer personId

    );

    
}

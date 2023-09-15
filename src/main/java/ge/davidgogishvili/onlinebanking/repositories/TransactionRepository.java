package ge.davidgogishvili.onlinebanking.repositories;

import ge.davidgogishvili.onlinebanking.entities.TransactionDomain;
import org.springframework.data.jpa.repository.JpaRepository;

//ამ რეპოზიტორით ვურთიერთOბთ ბაზასთან
public interface TransactionRepository extends JpaRepository<TransactionDomain, Integer> {

}

package ge.davidgogishvili.onlinebanking.repositories;

// ვქმნით იუზერრეპოზიტორის (იმიტომ რომ ბაზიდან უნდა წამოვიღოთ ხოლმე იუზერები)

import ge.davidgogishvili.onlinebanking.entities.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain, Integer> {
    Optional<UserDomain> findAllByUsername(String username);

}

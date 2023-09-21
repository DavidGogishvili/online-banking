package ge.davidgogishvili.onlinebanking.repositories;

import ge.davidgogishvili.onlinebanking.entities.UserRoleDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleDomain, Integer> {

List<UserRoleDomain> findAllByUserId(Integer userId);

}

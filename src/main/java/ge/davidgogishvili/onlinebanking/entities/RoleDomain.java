package ge.davidgogishvili.onlinebanking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Setter
@Getter
@Table (schema = "public", name = "roles")
public class RoleDomain extends UserRoleDomain implements GrantedAuthority  {


    @Id
    private Integer id;

    private String name;


    @Override
    public String getAuthority() {
        return name;
    }
}

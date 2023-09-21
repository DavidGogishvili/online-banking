package ge.davidgogishvili.onlinebanking.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(schema = "public", name = "user_roles")

public class UserRoleDomain {

    @Id
    private Integer id;


    private Integer userId;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleDomain role;

}

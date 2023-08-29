package ge.davidgogishvili.onlinebanking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "persons")
public class Person {

    @Id
    private Integer id;


    @Column(name="personal_number")
    private  String personalNumber;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "birth_date")
    private String birthDate;

    @OneToMany
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private List<Account> accounts;

}



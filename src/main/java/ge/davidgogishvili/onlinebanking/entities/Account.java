package ge.davidgogishvili.onlinebanking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//თითოეული ცხრილისთვის კეთდება 1 რეპოზიტორი და თითოეული რეპოზიტორისთვის კეთდება 1 ენტიტი თუ იმ ცხრილთან მუშაობა გვჭირდება (ჩანაწერის შექმნა, ძებნა, წაშლა ან რამე სხვა ქმედება)

@Setter
@Getter
@Entity

@Table(schema = "public", name ="accounts")
public class Account extends BaseEntity_logs {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq_generator")
    @SequenceGenerator(name="account_seq_generator", sequenceName="accounts_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "person_id")
    private Integer personId;

    @ManyToOne
    @JoinColumn(name= "person_id", insertable = false, updatable = false)
    private Person person;

    private String name;
    private Double amount;
    private String iban;

    private Boolean blocked;



}

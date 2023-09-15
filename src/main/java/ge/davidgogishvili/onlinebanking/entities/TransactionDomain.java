package ge.davidgogishvili.onlinebanking.entities;


// პოჯო კლასი (კლასი, რომელშიც მონაცემებს ინახავენ მაგრამ ფუნქციონალს არ აკეთებენ) java pojo

//ვაკეთებ ენტიტის, სადაც აღვწერ ყველაფერს ტრანზაქციების შესახებ: რომელი ბაზიდან რომელი ცხრილიდან და რეები მექნება, რასაც გამოვიყენებ ტრანზაქციებისთვის



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



//აუცილებელია რომ სექუენსის ნეიმი არ მეორდებოდეს და გენერატორის სახელი წამოვიღოთ ბაზიდან. ასევე გენერატედ ვალუეს გენერატორი უნდა ემთხვეოდეს სექუენსგენერატორის სახელს
@Getter
@Setter
@Entity
@Table (schema = "public", name = "transactions")
@SequenceGenerator(name = "transactions_id_seq_generator", sequenceName = "transactions_id_seq", allocationSize = 1)
public class TransactionDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_id_seq_generator")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "debit_account_id")
    private Account debitAccount;


    @ManyToOne
    @JoinColumn(name = "credit_account_id")
    private Account creditAccount;

    @Column (name = "amount")
    private Double amount;

    @Column (name = "comment_text")
    private String comment;

}

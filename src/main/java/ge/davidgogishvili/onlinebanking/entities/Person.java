package ge.davidgogishvili.onlinebanking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
//თითოეული ცხრილისთვის კეთდება 1 რეპოზიტორი და თითოეული რეპოზიტორისთვის კეთდება 1 ენტიტი თუ იმ ცხრილთან მუშაობა გვჭირდება (ჩანაწერის შექმნა, ძებნა, წაშლა ან რამე სხვა ქმედება)

@Getter
@Setter
@Entity
@Table(schema = "public", name = "persons")
public class Person {

    @Id
    private Integer id;

    @Column(name = "personal_number")
    private String personalNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("დაბადების დღე") // რომელ ველსაც ვუწერ - სახელს უცვლის
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore // რომელ ველსაც ვუწერ - იმ ველს არ გამოიტანს, ასევე შეგვიძლია ველს დავუწეროთ და იმუშავებს
    @OneToMany
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private List<Account> accounts;

    // დავამატე ასაკი
    @JsonProperty ("ასაკი")
    public Integer getAge() {
        if (this.birthDate == null) {
            return null;
        }
        return LocalDate.now().getYear() - this.birthDate.getYear();
    }
}


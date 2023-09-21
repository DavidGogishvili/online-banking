package ge.davidgogishvili.onlinebanking.entities;

// ეს კლასი არის დაახლოებით ლოგირების კლასი, ჯერ-ჯერობით გამოვიტანოთ მარტო ის, თუ ვინ შექმნა ექაუნთი
//როცა ბევრი კლასი მექნება, რომელიც ამ კლასს დააექსთენდებს, საერთოდ არ დამჭირდება იმაზე ფიქრი, რომ იქვე გავწერო ქრიეითედ ბაი, ავტომატურად გაუკეთებს სხვა მეთოდებს
//ოღონდ არ უნდა დაგვავიწყდეს რო ბაზაში გავაკეთოთ შესაბამისი ქოლუმნი (ქრიეითედ ბაი)

import ge.davidgogishvili.onlinebanking.security.UserManager;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity_logs {
    @Column(name = "created_by")
    private Integer createdBy;

    //ეს მეთოდი შესრულდეს სანამ მონაცემი ბაზაშI ჩაემატება

    @PrePersist
    public void preInsert (){

       createdBy = UserManager.getCurrentUser().getId();

    }


    // ამ მეთოდს გამოვიყენებ ხოლმე იმისთვის, რომ ვნახო თუ ვინ გააკეთ აფდეითი სადმე (ჯერ არა)
    @PreUpdate
    public void oreUpdate () {

    }
}

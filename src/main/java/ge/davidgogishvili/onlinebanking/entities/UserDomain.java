package ge.davidgogishvili.onlinebanking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(schema = "public", name = "users")

//აქ ვქმნით იუზერების ენტიტის სახელად იუზერდომეინი
public class UserDomain implements UserDetails {

    @Id
    private Integer id;

    @Column(name = "email")
    private String username;

//    @Column(name = "password")
    private String password;

    private Boolean active;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {  //დროებითი ეკაუნტები (Aქაც თრუ)
        return Objects.equals(active, Boolean.TRUE);
    }

    @Override
    public boolean isAccountNonLocked() {   // დაბლოკილი ეკაუნტები, რახან ნონია, მაშინ ვაბრუნებთ თრუს
        return Objects.equals(active, Boolean.TRUE);
    }

    @Override
    public boolean isCredentialsNonExpired() {  // პაროლზე პირობა, რომ რამდენიმე პერიოდში განაახლოს, რახან ნონია მაშინ ვაბრუნებთ თრუს
        return Objects.equals(active, Boolean.TRUE);
    }

    @Override
    public boolean isEnabled() {  // თუ არის აქტიური იუზერი (დაბლოკილი ხომ არ არის)
        return Objects.equals(active, Boolean.TRUE);
    }
}

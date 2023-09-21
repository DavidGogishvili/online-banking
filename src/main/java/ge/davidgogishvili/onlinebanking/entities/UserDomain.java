package ge.davidgogishvili.onlinebanking.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(schema = "public", name = "users")

//აქ ვქმნით იუზერების ენტიტის სახელად იუზერდომეინი
public class UserDomain implements UserDetails {

    @Id
    private Integer id;
//    private Integer UserId;

    @Column(name = "email")
    private String username;

//    @Column(name = "password")
    private String password;

    private Boolean active;

    @Transient  // რომ არ ეგონოს ბაზის ველი, მაგიტომ ვუწერ
    private List <RoleDomain> roles;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {  // აქ უნდა ჩავსეტოთ როლები
        if (roles == null) {
            return new ArrayList<>();
        }
            return roles;
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

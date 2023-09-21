package ge.davidgogishvili.onlinebanking.security;


import ge.davidgogishvili.onlinebanking.entities.UserDomain;
import ge.davidgogishvili.onlinebanking.entities.UserRoleDomain;
import ge.davidgogishvili.onlinebanking.repositories.UserRepository;
import ge.davidgogishvili.onlinebanking.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

// კლასი, რომელშიც გავაკონტროლებთ იუზერებს, აუცილებელია, რომ იმპლემენტაცია გაუკეთოს UserDetailsService - ს

@RequiredArgsConstructor
public class UserManager implements UserDetailsService{

    private final UserRepository userRepository;
    private final UserRoleRepository UserRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDomain> users = userRepository.findAllByUsername(username);
        if (users.isEmpty()) {
            throw new RuntimeException("User % Not Found");
        }
        var user = users.get();
        var roles = UserRoleRepository.findAllByUserId(user.getId());
//        List<RoleDomain> roles = new ArrayList<>();
//        for (UserRoleDomain r: uroles) {
//            roles.add(r.getRole());
//        }
        user.setRoles(roles.stream().map(UserRoleDomain::getRole).toList());                                           //ვამატებ ავტორიზაციაში როლებს
        return user;
    }


    public static UserDomain getCurrentUser() {
        var authorization = SecurityContextHolder.getContext().getAuthentication();
        if (authorization == null || authorization.getPrincipal() == null) {
            throw new RuntimeException(
                    "Authorization Needed"
            );
        }
        if (
                authorization.getPrincipal() instanceof UserDomain user
        ) {
            return user;
        }
        throw new RuntimeException("Anonimous");
    }

}

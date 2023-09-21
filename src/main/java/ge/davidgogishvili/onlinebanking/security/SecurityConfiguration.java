package ge.davidgogishvili.onlinebanking.security;

import ge.davidgogishvili.onlinebanking.repositories.UserRepository;
import ge.davidgogishvili.onlinebanking.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


//მნიშვნელოვანია ეს ქვედა 3 ანოტაცია

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;


    @Bean  // ვუთითებთ, რომ ბკრიპტი გამოიყენოს პაროლების დასაშიფრად
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

// ამეების გაწერის მერე, ჩვენს ლინკზე უბრალოდ ვეღარ შევალთ, საჭიროა იუზერი და პაროლი
//სანამ არ დავაკონფიგურირებთ, დასტარტვისას გამოიტანს ხოლმე პასვორდს ერთჯერადად (ყოველ ჯერზე ახალს), იუზერი არის user


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeHttpRequests(
                        (authorize) -> authorize
                        .requestMatchers("/persons", "/libraries/**").permitAll()       // აქ ვწერთ მოთხოვნას (ლინკს), სადაც გადასვლის შემდეგ ან მოგთხოვს დალოგინებას ან ფაბლიქი დაგხვდება
                        .anyRequest().authenticated()                                        // პერმიტოლ ნიშNავს ფაბლიქს. /libraries/** < ეს ნიშNავს, რომ ლიბრარის ფოლდერშI რაცაა, ის გაფაბლიქდეს
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .exceptionHandling( (c) -> c.authenticationEntryPoint(
                        (request,  response,  authExeption) -> response.sendError(401, "Forbidden") ));
        ;
        // @formatter:on
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }


    //ეს არის კონფიგურაცია, სადაც შეგვიძლია გავუწეროთ იუზერი რა იყოს, პაროლი რა ქონდეს, და რომელი როლი ქონდეს,
    // არაა აუცილებელი(მაინც იმუშავებს) მაგრამ შეგვიძლია ჩავუმატოთ ანოტაცია @Deprecated - ეს უბრალოდ იმიტომ, რომ კოდშI 1-1 სიტყვას ყვითლად არ გაუსვას ქვემოდან ხაზი
//    @Deprecated
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("Dav")
//                .password("Aa123123")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);

    // @formatter:on


// როცა იუზერების კლასს გავაკეთებთ, მერე უკვე ამ კოდში ინმემორი აღარ გვინდა და იუზერ მენეჯერს გადავცემთ და ასევე ვაბრუნებთ კიდეც:

    @Deprecated
    @Bean
    public UserManager userDetailsService() {

        return new UserManager(userRepository, userRoleRepository);
    }
// @formatter:on
}




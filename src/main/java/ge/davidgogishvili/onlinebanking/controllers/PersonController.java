//აქ ვწერ ისეთ ფუნქციებს,  ლინკზე გადასვლის მერე აქტიურდება (რექვესთმაფინგი აკეთებს, ჯერ უნდა დომეინი (ამ შემთხვევაში სერვერი (ლოკალჰოსტ 8080 და მერე დახრილი ხაზი
// მერე ამეების მიბმა შემეძლება ფრონტის ჰტმლ ფაილზე და რო დააჭერენ რაღაც კნოპკას
//ის ფუნქცია ჩაირთვება
package ge.davidgogishvili.onlinebanking.controllers;

import ge.davidgogishvili.onlinebanking.entities.Account;
import ge.davidgogishvili.onlinebanking.entities.Person;
import ge.davidgogishvili.onlinebanking.models.AccountCreateModel;
import ge.davidgogishvili.onlinebanking.models.PersonSearchModel;
import ge.davidgogishvili.onlinebanking.repositories.AccountRepository;
import ge.davidgogishvili.onlinebanking.services.PersonService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("persons")
public class PersonController {

    private final PersonService personService;
    @Getter
    private final AccountRepository accountRepository;

        @GetMapping
        public List<Person> search (PersonSearchModel params) {
            var persons = personService.search(params);
//            var ans = new ArrayList<PersonModel>();
//            for (var person: persons) {
//                ans.add(new PersonModel(person.getId(), person.getPersonalNumber(), person.getFirstName(), person.getLastName(), person.getBirthDate()));
//            }

            return persons;
        }


        @GetMapping("{id}")
        public  Person person(@PathVariable Integer id) {
                   return personService.getPerson(id);

        }

    @GetMapping("{id}/accounts")
    public List<Account> personAccounts(@PathVariable Integer id) {
        return personService.getPersonAccounts(id);

    }
    @PostMapping("{personId}/accounts")
    public Account personCreateAccount(@PathVariable Integer personId, @RequestBody AccountCreateModel accountCreateModel) {
            return personService.personCreateAccount(personId, accountCreateModel);
    }

}

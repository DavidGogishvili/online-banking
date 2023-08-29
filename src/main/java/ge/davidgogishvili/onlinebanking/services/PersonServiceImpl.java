package ge.davidgogishvili.onlinebanking.services;

import ge.davidgogishvili.onlinebanking.entities.Account;
import ge.davidgogishvili.onlinebanking.entities.Person;
import ge.davidgogishvili.onlinebanking.models.AccountCreateModel;
import ge.davidgogishvili.onlinebanking.repositories.AccountRepository;
import ge.davidgogishvili.onlinebanking.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PersonServiceImpl implements ge.davidgogishvili.onlinebanking.services.PersonService {

    private final PersonRepository personRepository;
    private final AccountRepository accountRepository;


    @Override
    public List<Person> search(String firstName, String lastName, String personalNumber) {

        if ( firstName == null) {
            firstName = "";
        }

        if ( lastName == null) {
            lastName = "";
        }

        if ( personalNumber == null) {
            personalNumber = "";
        }

              return personRepository.findPersons("%" + firstName + "%", lastName + "%", "%" + personalNumber + "%");
    }

    @Override
    public Person getPerson(Integer id) {
        return personRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Account> getPersonAccounts(Integer id) {
        return accountRepository.findAllByPersonId(id);
    }

    @Override
    public Account personCreateAccount(Integer personId, AccountCreateModel accountCreateModel) {
        if (!personRepository.existsById(personId)) {
            throw new RuntimeException("ასეთი აიდით" + personId + " არარსებოობს!!!");
        }
        Account account = new Account();
        account.setPersonId(personId);
        account.setName(accountCreateModel.name());
        account.setIban(accountCreateModel.iban());
        account.setAmount(0.0);

        accountRepository.save(account);
        return account;

    }
}
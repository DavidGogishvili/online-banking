package ge.davidgogishvili.onlinebanking.services;

import ge.davidgogishvili.onlinebanking.entities.Account;
import ge.davidgogishvili.onlinebanking.entities.Person;
import ge.davidgogishvili.onlinebanking.models.AccountCreateModel;
import ge.davidgogishvili.onlinebanking.models.PersonSearchModel;

import java.util.List;

public interface PersonService {


    List<Person> search (PersonSearchModel params);


    List<Person> search(String firstName, String lastName, String PersonalNumber);

    Person getPerson(Integer id);

    List<Account> getPersonAccounts(Integer id);

    Account personCreateAccount (Integer personId, AccountCreateModel accountCreateModel);
}

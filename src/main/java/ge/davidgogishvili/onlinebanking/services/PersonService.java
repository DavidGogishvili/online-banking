package ge.davidgogishvili.onlinebanking.services;

import ge.davidgogishvili.onlinebanking.entities.Account;
import ge.davidgogishvili.onlinebanking.entities.Person;
import ge.davidgogishvili.onlinebanking.models.AccountCreateModel;

import java.util.List;

public interface PersonService {


    List<Person> search (String firstName, String lastName, String personalNumber);

    Person getPerson(Integer id);

    List<Account> getPersonAccounts(Integer id);

    Account personCreateAccount (Integer personId, AccountCreateModel accountCreateModel);
}

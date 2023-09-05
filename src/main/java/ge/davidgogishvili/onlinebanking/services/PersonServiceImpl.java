package ge.davidgogishvili.onlinebanking.services;

import ge.davidgogishvili.onlinebanking.entities.Account;
import ge.davidgogishvili.onlinebanking.entities.Person;
import ge.davidgogishvili.onlinebanking.models.AccountCreateModel;
import ge.davidgogishvili.onlinebanking.models.PersonSearchModel;
import ge.davidgogishvili.onlinebanking.repositories.AccountRepository;
import ge.davidgogishvili.onlinebanking.repositories.PersonRepository;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PersonServiceImpl implements ge.davidgogishvili.onlinebanking.services.PersonService {

    private final PersonRepository personRepository;
    private final AccountRepository accountRepository;


    @Override
    public List<Person> search(PersonSearchModel params) {






//              return personRepository.findPersons("%" + firstName + "%", lastName + "%", "%" + personalNumber + "%");


        // შემოვიღე ახალი ცვლადი ანს რომელიც პერსონრეპოზიტორიშI აკეთებს ლამბდა ფუნქციას
        Page<Person> ans = personRepository.findAll((root, query, criteriaBuilder) -> {


            List<Predicate> predicates = new ArrayList<>();


            if (StringUtils.isNotEmpty(params.personalNumber())){
                predicates.add(criteriaBuilder.like( root.get("personalNumber"), "%" + params.personalNumber() + "%"));
            }
            if (StringUtils.isNotEmpty(params.firstName())) {
                predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + params.firstName() + "%"));
            }

            if (StringUtils.isNotEmpty(params.lastName())){
                predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + params.lastName() + "%"));
            }

            if (StringUtils.isNotEmpty(params.iban())) {
                Root<Account> accountRoot = query.from(Account.class);
                Subquery<Account> sub = criteriaBuilder.createQuery().subquery(Account.class);
                sub.select(accountRoot.get("personId"));
                predicates.add(
                        criteriaBuilder.in(root.get("id"))
                                .value(
                                        sub.where(criteriaBuilder.like(accountRoot.get("iban"), "%" + params.iban() + "%"))
                                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));




            
           }, Pageable.ofSize(10));

        return ans.stream().toList();
    }

    @Override
    public List<Person> search(String firstName, String lastName, String PersonalNumber) {
        return null;
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
package ge.davidgogishvili.onlinebanking.services;

import ge.davidgogishvili.onlinebanking.entities.TransactionDomain;
import ge.davidgogishvili.onlinebanking.models.TransactionAddModel;
import ge.davidgogishvili.onlinebanking.repositories.AccountRepository;
import ge.davidgogishvili.onlinebanking.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // - კონსტრუქტორში ამატებს იმ ველებს, რომლებსაც ფაინალი აქვს მითIთებულ, არსებობს allargconstructor - ეს უკეთებს ყველას, არა მარტო ფაინალს
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;


    //რას ვაკეთებთ ტრანზაქციების დროს
    @Override
    public void addTransaction(TransactionAddModel data) {

        var transaction = new TransactionDomain();

        transaction.setDebitAccount(accountRepository.findById(data.debitAccountId()).orElseThrow());
        transaction.setCreditAccount(accountRepository.findById(data.creditAccountId()).orElseThrow());

        if (data.amount() == null || data.amount() < 0.1){
            throw new RuntimeException("Wrong amount");
        }
        transaction.setAmount(data.amount());
        transaction.setComment(data.comment());
        transactionRepository.save(transaction);

    }
}

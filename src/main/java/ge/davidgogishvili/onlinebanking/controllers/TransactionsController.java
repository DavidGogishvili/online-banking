package ge.davidgogishvili.onlinebanking.controllers;

import ge.davidgogishvili.onlinebanking.models.TransactionAddModel;
import ge.davidgogishvili.onlinebanking.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
public class TransactionsController {

    private final TransactionService service;

    @PostMapping
    public ResponseEntity<?>  addTransaction (@RequestBody TransactionAddModel data) {
        try {
            service.addTransaction(data);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }


    }
}

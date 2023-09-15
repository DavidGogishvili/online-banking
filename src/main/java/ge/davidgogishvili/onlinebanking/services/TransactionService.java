package ge.davidgogishvili.onlinebanking.services;

import ge.davidgogishvili.onlinebanking.models.TransactionAddModel;

public interface TransactionService {

    void addTransaction (TransactionAddModel data);
}

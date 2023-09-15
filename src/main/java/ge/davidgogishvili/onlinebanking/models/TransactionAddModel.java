package ge.davidgogishvili.onlinebanking.models;


//ობიექტი, რომელსაც მივიღებთ ტრანსაქშენ დომეინში, რომ ახალი ტრანზაქცია დაემატოს
public record TransactionAddModel(
        Integer creditAccountId,

        Integer debitAccountId,

        Double amount,

        String comment
) {
}

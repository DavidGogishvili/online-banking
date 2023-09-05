package ge.davidgogishvili.onlinebanking.models;

public record PersonSearchModel
        (
                String firstName,
                String lastName,
                String personalNumber,
                String iban
        )


{
}

package ge.davidgogishvili.onlinebanking.models;


import lombok.Builder;


@Builder

public record PersonModel(Integer id, String firstName, String lastName, String personalNumber, java.time.LocalDate birthDate) {




}

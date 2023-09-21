package ge.davidgogishvili.onlinebanking.test;

import ge.davidgogishvili.onlinebanking.entities.Person;

public class Human extends Person {

    public String getFullName() {
        return super.getFirstName() + " " + super.getLastName();
    }

}

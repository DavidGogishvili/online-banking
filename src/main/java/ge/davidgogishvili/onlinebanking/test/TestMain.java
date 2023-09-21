package ge.davidgogishvili.onlinebanking.test;

import ge.davidgogishvili.onlinebanking.entities.Account;
import ge.davidgogishvili.onlinebanking.entities.Person;

import java.util.ArrayList;
import java.util.Arrays;
public class TestMain {

    public void test () {

        TestGeneric<Person> tg = new TestGeneric<>();

        tg.setElement(new Human());
        tg.getElement().setFirstName("დავით");

        System.out.println(tg.getElement());

        TestGeneric<Account> ac = new TestGeneric<>();
        ac.setElement(new Account());


    }



// გავაკეთეთ ახალი კლასი "ტესტი", სადაც გავწერეთ უბრალო მასივი (10 კომპონენტიანი, სახელად persons) პირველ ობიექტს ვარქმევ ტესტს
    public void test1 () {
        Person[] persons = new Person[10];

        persons [0] = new Person();
        persons [1] = new Person();
        persons [1].setFirstName("test");

        persons [3] = new Person();

        System.out.println(Arrays.toString(persons));
// არაილისტი (უფრო ძერსკი მასივია, შეგვიძლია ჩავამატოთ ხოლმე და ამოვშალოთ რაღაცეები, არ გვჭირდება მითითება რამდენკომპონენტიანი უნდა იყოს)
//შევქმენით ახალი არაილისტი სახელად პერსონლისტი. ორჯერ დამატება იმიტომ წერია, რომ ორჯერ დაამატოს ახალი კომპონენტი (თვითონ ანიჭებს ინდექსს), შემოვიტანეთ ცვლადი პ
// და ჩავწერე პირველ კომპონენტად(ობიექტად). იმ პ - ში სხვა კომპონენტებისგან განსხვავებით, მარტო სახელი მივუთითე (ჩასეტილისახელი).
//მერე გეთ მეთოდით ვიძახებ პერსონლისტიდან პირველ ელემენტს და ბოლოს ვშლი მენოლე ინდექსის მქონეს <> ამ სიმბოლოების შორის ვწერთ არაილისტის ტიპს (რა ტიპის მასივი იქნება)






        ArrayList personList = new ArrayList();
        personList.add(new Person());
        personList.add(new Person());

        Person p = (Person) personList.get(1);
        p.setFirstName("ჩასეტილისახელი");

        personList.get(1);

        personList.remove(0);

        System.out.println(personList);


    }

}

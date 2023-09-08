package ge.davidgogishvili.onlinebanking.models;


//შევქმნათ კლასი და აღვწეროთ მეთოდი პრინტნეიმი
//ლამბდა არ მუშაობს, თუ ერთზე მეტი მეთოდია აღწერილი, ამიტომ ანოტაცია უნდა დავუწეროთ რომ არის ფუნქციონალური ინტერფეისი
// (ამით თავს ვიზღვევთ, რომ ერთზე მეტი მეთოდი არ აღიწერება ამ ინტეტფეისში)

@FunctionalInterface
public interface Calculator {

    Integer calculate(Integer a, Integer b);


}

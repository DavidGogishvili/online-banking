package ge.davidgogishvili.onlinebanking.test;

//thread არის სპეციალური ჯავას ჩაშენებული კლასი, რომელიც საშUალებას გვაძლევს რამდენიმე ფუნქცია გავუშვათ ერთდროულად
//  თუ მინდა გავაკეთო თრედი (ანუ რამდენიმე ფუნქცია პარალელურ რეჟიმში გაეშვას), გავაკეთო უნდა ნებისმიერი კლასი, რომელიც აექსთენდებს თრედს extends Threads
//   მერე იქ გავაკეთო ფუნქცია ფაბლიქ ვოიდ რან (ანოტაცია @ოვერრაიდ)
// რომელიც არ იღებს არგუმენტებს
//და იქ ტანში დავწერო რამდენიმე პარალელური რამ, რასაც გავუშვებ პარალელურ რეჟიმში ოღონდ რანის მაგივრად უნდა გავუშვათ სტარტი თუ გვინდა, რომ ქნას ის, რაც გვინდა
//ლამბდა ფუნქცია არის ფუნქცია, რომლის ინტერპრეტაციაც შეიძლება კოდშივე


public class TestRun extends Thread{



}




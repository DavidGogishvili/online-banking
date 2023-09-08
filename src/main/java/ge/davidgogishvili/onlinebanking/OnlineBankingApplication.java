package ge.davidgogishvili.onlinebanking;

import ge.davidgogishvili.onlinebanking.models.Calculator;
import ge.davidgogishvili.onlinebanking.models.Calculator_options;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class OnlineBankingApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingApplication.class, args);
//		new OnlineBankingApplication().init(); // - ეს რომ გავუშვა და ზედა ხაზი დავტოვო, დასტარტვისას ძააან ცოტა რამეს გამოიტანს კონსოლში და ერორების შემთხვევაშI ვერ გავიგებ ვერაფერს
		//მარამ შემიძლია, ასევე შემიძLია ეპლიკეიშენ ფროფერთისში დებაგ თრუ დავწერო და უფრო მეტ რამეს გამოიტანს ხოლმე
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ge.davidgogishvili.onlinebanking.OnlineBankingApplication.class);}


	@PostConstruct
	public void init (){

//-----------------------------------სტრიმები-------------------------------------------------------------------
		//შევქმნათ მასივი სახელად ერეი და მინდა ვიპოვო მაქსიმუმი ან რაღაცეები (მაგალითად ჯამი, ან 5 ის ტოლი თუა რომელიმე, ან ხუთზე ნაკლები და ა.შ)

		System.out.println("/n/n/n/n");
		List<Integer> array = List.of(1, 24, 2344, 21344, 13, 44);

		//   სიაში არსებული მაქსიმუმი:

		List<Integer> ans = new ArrayList<>();

		Integer max = array.get(0);
		for (Integer el : array) {

			if (el > max) {
				max = el;
			}

		}

		System.out.println(max);

		int maximum = array.stream().max(Integer::compare).get(); // >> ეს მეთოდი, რომელსაც ეხლა მივანიჭებ ცვლადის სახელს მაქსიმუმ, აკეთებს ყველაფერ ამას:
		System.out.println(maximum);

		// ეხლა დავთვალოთ მინიმალური:

		int minimum = array.stream().max((a,b) -> b - a).get();
		System.out.println(minimum);


		//მასივში არსებული ყველა ელემენტი რომელიც 5-ზე მეტია:


		List<Integer> array1 = new ArrayList<>();
		for (Integer el : array) {
			if (el > 5) {
				array1.add(el);
			}
		}

		System.out.println(array1);
		System.out.println(array.stream().max(Integer::compare).get());

		//მასივში არსებული ყველა ელემენტი რომელიც 5-ზე მეტია(filter მეთოდი):

		List<Integer> array2 = array.stream().filter((x) -> x>5).collect(Collectors.toList());

		System.out.println(array2);


		//მაქსიმალური რიცხვი, რომელიც ნაკლებია 100 - ზე:

		System.out.println(array.stream().filter((x) -> x<100).mapToInt(x ->x).max().orElse(-1)); //- ორელსე დაბეჭდავს -1 -ს თუ მასეთი
		//რიცხვი არ იარსებებს, maptoint (x->x ნიშNავს, რომ ნებისმიერი რამე გადაეცემა, ამ შემთხვევაშI იქსი და ბრუნდება იგივე რამე)
		// - ს გადაყავს ნებისმიერ არგუმენტი სხვა ტიპად, იმიტომ რომ სტრინგი აბრუნებს სტრინგს და არა ინტს


		//კენტ რიცხვებს შორის მაქსიმუმი: (ლუწის შემშთხვევაში ==0 იქნება)
		System.out.println(array.stream().filter((x) -> (x & 1) == 1).mapToInt(x->x).max().orElse(-1));

		// კენტი რიცხვების ჯამი და ამის მიხედვით იტაგდალეე:
		System.out.println(array.stream().filter((x) -> (x & 1) == 1).mapToInt(x->x).sum());






//------------------------------------------ლამბდა ფუნქცია-----------------------------------------------------------------------------------------
	//()-> - ეს არის ლამბდა ფუნქცია, რომელსაც არ ჭირდება ბევრი კლასების და იმპლემენტაციების შექმნა, რახან ქვემოთ აღწერილი გვაქვს, რომ
	//პრინტს გამოაქვს ენიმალის პრინტნეიმი, თავისით აკეთებს ყველაფერს, მოაქვს ენიმალიდან პრინტნეიმი და იქ უკვე ჩვენი ნებაა ტექსტში რას ჩავუწერთ.


		//რადგან მეთოდი 1 ხაზიანია, ფიგურული ფრჩხილი არ გვჭირდება, როცა რამდენიმე ხაზია, მაშინ ჩვეულებრივად, ფიგურულ ფრჩხილს ვხმარობთ

//		print(() -> System.out.println("პრინტი"));

		//რახან არგუმენტის გადაცემა შეგვიძლია (ამ შემთხვევაში ტექსტის, ასევე შეგვიძლია შევქმნათ ობიექტი და გადავცეთ ამ ობიექტს ჩვენი არგუმენტი,
		// ხოლო ფუნქცია პრინტს გადავცეთ ეს ობიექტი - უფრო მარტივი გამოვა:
		// ლამბდა არ მუშაობს თუ ერთზე მეტი მეთოდია აღწერილი
		//შემიძლია გარე ცვლადი შემოვიტანო და ის გავაკეთებინო ლამბდას, როგორც მაგალითად ტექსტ ცვლადი შემოვიტანე



//		String text = "გარე ცვლადი";
//		Calculator lambda = () -> System.out.println(text);
//		print(lambda);
//
//		//ასევე შემიძლია რამდენიმე ლამბდა გავაკეთო ერთ ინტერფეისზე, მაგალითად (რამდენი ლამდაც მინდა, იმდენ ლამბდას გავაკეთებ ერთ ინტერფეისზე):
//
//		Calculator lambda2 = () -> System.out.println("აჰაჰაჰა");
//
//		print(lambda2);

		//---------------------------------------------------------------------------------------------------------------------------------
		// გავაკეთოთ მათემატიკური ფუნქციები (კალკულატორში პრინტნამე შევცვალე კალკულეიტით და გადავეცი 2 ცვლადი ა და ბ. შემოვიღე ეს 2 ცვლადი:

		int a = 10;
		int b = 50;
		int c = a+b; // ამას ფუნქციაში არ ჩავწერ

		//ვაკომენტებ წინა ლამბდებს იმიტომ რომ ის ტექსტზე იყო. პრინტნეიმს ვუცვლი სახელს ვარქმევ კალკულეიტს და შემომაქვს 2 ცვლადი:
		// კალკულატორ ინტერფეისში ვოიდის მაგივრად კალკულეიტ ფუნქციაშI დავაბრუნოთ ინტეჯერი

		//შევქმნათ ახალი ცვლადები, რათა კიდევ უფრო გავამარტივოთ:

		Calculator pliusi = (x, y) -> x + y;
		Calculator minusi = (x, y) -> x - y;
		Calculator namravli = (x, y) -> x * y;
		Calculator gakofa = (x, y) -> y / x;

		System.out.println(print(pliusi, a, b));
		System.out.println(print(minusi, a, b));
		System.out.println(print(namravli, a, b));
		System.out.println(print(gakofa, a, b));

		//ვაპირებ ესენი ცალკე აღვწერო და მერე უფრო ადვილად გამოვიყენო და ვქმნი ახალ კლასს სახელად კალკულატორ_ოფშენს. შესაბამისად, პირდაპირ გადავცემ ფუნქციას:
		System.out.println(print(Calculator_options::jami, a, b));
		System.out.println(print(Calculator_options::minusi, a, b));
		System.out.println(print(Calculator_options::namravli, a, b));
		System.out.println(print(Calculator_options::gakofili, a, b));




	}



	private Integer print(Calculator c, Integer a, Integer b) {
		return c.calculate(a, b);
	}

}

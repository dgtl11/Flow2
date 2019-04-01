package chpt02.lambdas;

import java.util.function.Predicate;

public class FindMatchingAnimals {
	private static void print(Animal animal, Predicate<Animal> trait) {
		if(trait.test(animal))
			System.out.println(animal);
}

	public static void main(String[] args) {
		//print(new Animal("fish", false, true), a -> a.canHop());
		//print(new Animal("kangaroo", true, false), a -> a.canHop());
		
		Animal fish = new Animal("fish", false, true);
		Animal kangaroo = new Animal("kangaroo", true, true);
		
		print(fish, test -> test.canHop());
		print(kangaroo, test -> test.canHop());
		
		
		
	}
}
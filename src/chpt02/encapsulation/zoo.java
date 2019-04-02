package chpt02.encapsulation;

public class zoo {

	public static void main(String[] args) {
		
		Animal bird = new Animal("dog", -15);

		System.out.println(bird.getAge());
		System.out.println(bird.getSpecies());
		
	}
	
}

package chpt02.encapsulation;

public class Animal {
	
	private String species;
	private int age;

	// -- getter Methoden zum erfragen der Variablen --
	public String getSpecies() {
		return species;
	}
	
	public int getAge() {
		return age;
	}
	
	
	// -- Konstruktor mit direkter Erstellung von Spezies und Alter
	public Animal(String species, int age) {
		this.setSpecies(species);
		this.setAge(age);
	}
	
	
	// -- setter Methoden zum ver�ndern der Variablen --
	public void setSpecies(String species) {
		if (species == null || species.trim().length() == 0) {
			System.out.println("Bitte eine Spezies eingeben.");
		}
		else {
			this.species = species;
		}
	}
	
	public void setAge(int age) {
		if (age < 0) {
			System.out.println("Bitte keine negativen Zahlen eingeben.");
		}
		else {
			this.age = age;
		}
	}
}

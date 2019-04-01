package chpt02.interfacegames;

public class SafariGoneWrong {

	public static void main(String[] args) {
		
		Lion Mufasa = new Lion();
		
		if (Mufasa.canHuntWhileRunning()) {
			System.out.println("He's gonna get you...");
		}
		
		
			
		if ((Math.random()*10) > 6) {
			Mufasa.stumble();
			System.out.println("you lucky bastard!");
		}
		
		else {
			System.out.println("YOU DIED!");
		}
		
	}
	
	
}

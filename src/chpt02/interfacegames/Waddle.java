package chpt02.interfacegames;

public interface Waddle {
	
	boolean isQuadruped();
	abstract double getMaxSpeed();
	default void stumble() {
		System.out.println("it stumbled... poor thing");
	}
	
}

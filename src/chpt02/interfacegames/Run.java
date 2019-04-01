package chpt02.interfacegames;

public interface Run extends Walk {

	public abstract boolean canHuntWhileRunning();
	abstract double getMaxSpeed();
	default void stumble() {
		System.out.println("it stumbled! Run faster!");
	}
}
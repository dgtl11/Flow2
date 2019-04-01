package chpt02.interfacegames;

public class Lion implements Walk, Run {

	public boolean isQuadruped() {
		return true;
	}

	public boolean canHuntWhileRunning() {
		return true;
	}

	public double getMaxSpeed() {
		return 100;
	}
	
}
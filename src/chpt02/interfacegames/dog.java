package chpt02.interfacegames;

public class dog implements Run {

	@Override
	public boolean isQuadruped() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canHuntWhileRunning() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public double getMaxSpeed() {
		// TODO Auto-generated method stub
		return 35;
	}

	
	
}

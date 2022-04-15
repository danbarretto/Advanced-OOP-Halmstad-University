

public class SinusStrategy implements Sampler {

	private double t, dt;
	
	public SinusStrategy(double start, double deltaT) {
		t = start;
		dt = deltaT;
	}
	
	@Override
	public double read() {
		double x = t;
		t += dt;
		return (1+Math.sin(x))*30;
	}

}

public class PowerMethod {

	public double[][] power_method(double[][] input, double[] approximation, double tolerance, int maxIterations) {
		
		int interations= 0;
		int error = 0;

		boolean converges = true;

		double oldEigenValue = 0;
		double currEigenValue = 0;

		for (int i = 0; converges && (error >= tolerance); i++) {
			oldEigenValue = approximation[0][0];
			approximation = 
		}
		if (iterations >= maxIterations) {
			return null;
		}
	}

}
public class PowerMethod {

	public double[] power_method(double[][] input, double[] approximation, double tolerance, int maxIterations) {
		
		int iterations= 0;
		double error = 0;

		boolean converges = true;

		double oldEigenValue = 0;
		double currEigenValue = 0;

		for (int i = 0; converges && (error >= tolerance); i++) {
			oldEigenValue = approximation[0];
			approximation = Matrix.multiplyMatrixVector(approximation, input);

			currEigenValue = approximation[0];
			error = Math.abs(oldEigenValue - currEigenValue);

			converges = ((currEigenValue / oldEigenValue) != 1);
			iterations++;
			if (iterations >= maxIterations) {
				throw new RunTimeException("Max number of iterations reached.");
			}
		}
			System.out.println("Number of iterations: " + iterations);
			System.out.println("Approximate eigenvalue: " + currEigenValue);
			System.out.println("Approximate eigenvector: \n");
			Matrix.print(approximation);

			return approximation;
	}
}

public class JacobiIteration {
	
	public double[] jacobi_iter(double[][] a, double[] x, double[] b, double tolerance, int maxIter) {
		double[][] diag = new double[a.length][m[0].length];
		double[] x1 = x;
		for(int i = 0; i < a.length; i++) {
			for(int j =0; j < a[0].length; j++) {
				if(i==j) diag[i][j] = a[i][j];
				else diag[i][j] = 0.0;
			}
		}
		//since 3x3:
		double[][] low = {{0.0, a[0][1], a[0][2]}, {0.0, 0.0, a[1][2]}, {0.0, 0.0, 0.0}};
		double[][] upp = {{0.0, 0.0, 0.0}, {a[1][0], 0.0, 0.0}, {a[2][0], a[2][1], 0.0}};
		for(int i = 0; i < maxIter; i++) {
			double[][] negLU = scalarMultiply(-1.0, a);
			double[] ax = Matrix.multiplyMatrixVector(x, negLU);
			double[] axplusb = Matrix.add(ax, b)
			x1 = Matrix.forwardSubstitution(diag, axplusb); //however this is called in vishaaks's thing
			double[] xminusx1 = Matrix.subtract(x, x1);
			double norm = Matrix.norm(xminusx1);
			if(norm < tolerance) {
				System.out.println("converged");
				return x1;
			} else {
				x = x1;
			}
		} //didn't return out the for loop
		System.out.println("didn't converge");
		return x1;
	}

}
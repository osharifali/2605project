
public class JacobiIteration {
	
	public double[] jacobi_iter(double[][] a, double[] x, double[] b, double tolerance, int maxIter) {
		// Matrix.print(a);
		double[][] diag = new double[a.length][a[0].length];
		// System.out.println("hi");
		double[] x1 = x;
		// Matrix.print(x1);
		double[][] low = new double[a.length][a[0].length];
		double[][] upp = new double[a.length][a[0].length];
		// Matrix.print(a);
		// System.out.println("hello");
		for(int i = 0; i < a.length; i++) {
			for(int j =0; j < a[0].length; j++) {
				if(i==j)  {
					diag[i][j] = a[i][j];
					low[i][j] = 0.0;
					upp[i][j] = 0.0;
					//upp[i][j] = a[i][j];
					//low[i][j] = a[i][j];
				} else if(i>j) {
					low[i][j] = a[i][j];
					upp[i][j] = 0.0;
					diag[i][j] = 0.0;
				} else {
					upp[i][j] = a[i][j];
					low[i][j] = 0.0;
					diag[i][j] = 0.0;
				}
			}
		}
		// Matrix.print(diag);
		// Matrix.print(low);
		// Matrix.print(upp);
		for(int i = 0; i < maxIter; i++) {
			double[][] negLowUp = Matrix.scalarMultiply(-1, Matrix.add(low, upp));
			double[] ax = Matrix.multiplyMatrixVector(x, negLowUp);
			double[] axplusb = Matrix.add(ax, b);
			x1 = Matrix.forwardSubstitution(diag, axplusb); 
			// Matrix.print(x1);
			double[] err = Matrix.subtract(x, x1);
			double normerr = Matrix.norm(err);
			if(normerr < tolerance) {
				System.out.println("converged");
				return x1;
			} else {
				// System.out.println(i);
				x = x1;
			}
		} //didn't return out the for loop
		System.out.println("didn't converge in "+ maxIter + " iterations");
		return x1;
	}

}
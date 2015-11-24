
public class JacobiIteration {
	
	public double[] jacobi_iter(double[][] a, double[] x, double[] b, double tolerance, int maxIter) {
		double[][] diag = new double[a.length][a[0].length];
		double[] x1 = x;
		double[][] low = a;
		double[][] upp = a;
		for(int i = 0; i < a.length; i++) {
			for(int j =0; j < a[0].length; j++) {
				if(i==j)  {
					diag[i][j] = a[i][j];
					upp[i][j] = a[i][j];
					low[i][j] = a[i][j];
				}
				if(i>j) {
					upp[i][j] = a[i][j];
					low[i][j] = 0.0;
					diag[i][j] = 0.0;
				} else {
					low[i][j] = a[i][j];
					upp[i][j] = 0.0;
					diag[i][j] = 0.0;
				}
			}
		}
		for(int i = 0; i < maxIter; i++) {
			double[][] negLowUp = Matrix.scalarMultiply(-1, Matrix.add(low, upp));
			double[] ax = Matrix.multiplyMatrixVector(x, negLowUp);
			double[] axplusb = Matrix.add(ax, b);
			// x1 = Matrix.forwardSubstitution(diag, axplusb); 
			//^fix that with however that is called in vishaaks's thing
			double[] err = Matrix.subtract(x, x1);
			double normerr = Matrix.norm(xminusx1);
			if(normerr < tolerance) {
				System.out.println("converged");
				return x1;
			} else {
				x = x1;
			}
		} //didn't return out the for loop
		System.out.println("didn't converge in "+ maxIter + " iterations");
		return x1;
	}

}
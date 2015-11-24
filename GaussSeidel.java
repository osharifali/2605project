
public class GaussSeidel {
	
	public double[] gs_iter(double[][] a, double[] x, double[] b, double tolerance, double maxIter) {
		double[][] diag = new double[a.length][a[0].length];
		double[] x1 = x;
		double[][] low = a;
		double[][] upp = a;
		for(int i = 0; i < a.length; i++) {
			for(int j =0; j < a[0].length; j++) {
				if(i==j)  {
					diag[i][j] = a[i][j];
					//upp[i][j] = a[i][j];
					//low[i][j] = a[i][j];
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
        	double[][] dplusl = Matrix.add(diag, low);
        	double[][] negU = Matrix.scalarMultiply(-1, upp);
        	double[] negUx = Matrix.multiplyMatrixVector(x, negU);
        	double[] negUXplusb = Matrix.add(negUx, b);
        	// x1 = Matrix.forwardSubstitution(dplusl, negUXplusb);
        	double[] err = Matrix.subtract(x1, x);
        	if(Matrix.norm(err) < tolerance) {
        		System.out.println("converged");
        		return x1;
        	}
        } //fell out of loop w/o converging
        System.out.println("didn't converge in " + maxIter + " iterations");
        return x1;

	}
}
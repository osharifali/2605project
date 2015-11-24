
public class GaussSeidel {
	
	public double[] gs_iter(double[][] a, double[] x, double[] b, double tolerance, double maxIter) {
		double[] x0 = x;
		double[][] s = a;
		double[][] t = a;
		for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i >= j) {
                    s[i][j] = a[i][j];
                    t[i][j] = 0;
                } else {
                    s[i][j] = 0;
                    t[i][j] = -1 * a[i][j];
                }
            }
        }

        for(int i = 0; i < maxIter; i++) {
        	x0 = x;
        	double[] tx = Matrix.multiplyMatrixVector(x0, t);
        	// x = Matrix.forwardSubstitution(s, Matrix.add(tx, b));
        	double[] err = Matrix.subtract(x, x0);
        	if(Matrix.norm(err) < tolerance) {
        		System.out.println("converged");
        		return x;
        	}
        } //fell out of loop w/o converging
        System.out.println("didn't converge in " + maxIter + " iterations");
        return x;

	}
}
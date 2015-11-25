import java.util.ArrayList;

public class GaussSeidel {

	private int iterToConv = 0;
	private ArrayList<double[]> x0List = new ArrayList<>();
	private ArrayList<double[]> xnList = new ArrayList<>();
	
	public double[] gs_iter(double[][] a, double[] x, double[] b, double tolerance, double maxIter) {
		double[][] diag = new double[a.length][a[0].length];
		double[] x1 = x;
		double[][] low = new double[a.length][a[0].length];
		double[][] upp = new double[a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j =0; j < a[0].length; j++) {
				if(i==j)  {
					diag[i][j] = a[i][j];
				}
				else if(i>j) {
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
		// Matrix.print(low);

        for(int i = 0; i < maxIter; i++) {
        	double[][] dplusl = Matrix.add(diag, low);
        	double[][] negU = Matrix.scalarMultiply(-1, upp);
        	double[] negUx = Matrix.multiplyMatrixVector(x, negU);
        	double[] negUXplusb = Matrix.add(negUx, b);
        	x1 = Matrix.forwardSubstitution(dplusl, negUXplusb);
        	double[] err = Matrix.subtract(x1, x);
        	if(Matrix.norm(err) < tolerance) {
        		System.out.println("converged");
        		iterToConv = i;
        		return x1;
        	} else {
        		x = x1;
        	}
        } //fell out of loop w/o converging
        System.out.println("didn't converge in " + maxIter + " iterations");
        iterToConv = -1;
        return x1;

	}

	public int getIterationCount() {
		return iterToConv;
	}

	public ArrayList<double[]> calculatexnList() {
		x0List = Matrix.create3x1Matrices();
		double[][] a = {{1, (1.0/2.0), (1.0/3.0)}, {(1.0/2.0), 1, (1.0/4.0)}, {(1.0/3.0), (1.0/4.0), 1}};
		double[] b = {0.1, 0.1, 0.1};
		double tolerance = 0.00005;
		int maxIter = 100;
		for(double[] x : x0List) {
			xnList.add(gs_iter(a, x, b, tolerance, maxIter));
		}
		return xnList;
	}
}
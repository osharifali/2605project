import java.util.ArrayList;

public class IterationTest {
	
	public static void main(String[] args) {
		// double[][] a = {{1, (1.0/2.0), (1.0/3.0)}, {(1.0/2.0), 1, (1.0/4.0)}, {(1.0/3.0), (1.0/4.0), 1}};
		// // Matrix.print(a);
		// double[] b = {0.1, 0.1, 0.1};

		// double[] x0 = {1.3, 3.4, 2.3};

		// double tolerance = 0.3;

		// int maxIter = 100;

		JacobiIteration ji = new JacobiIteration();
		ArrayList<double[]> sol = ji.calculatexnList();
		for(double[] d : sol)
			Matrix.print(d);
		int jacobiNumIters = ji.getIterationCount();
		System.out.println(jacobiNumIters);

		GaussSeidel gs = new GaussSeidel();
		// double[] gsSol = gs.gs_iter(a, x0, b, tolerance, maxIter);
		ArrayList<double[]> gsSol = gs.calculatexnList();
		for(double[] d : gsSol)
			Matrix.print(d);
		int gsNumIters = gs.getIterationCount();
		System.out.println(gsNumIters);
		// Matrix.print(gsSol);
	}
}
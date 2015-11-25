
public class IterationTest {
	
	public static void main(String[] args) {
		double[][] a = {{1, (1.0/2.0), (1.0/3.0)}, {(1.0/2.0), 1, (1.0/4.0)}, {(1.0/3.0), (1.0/4.0), 1}};
		// Matrix.print(a);
		double[] b = {0.1, 0.1, 0.1};

		double[] x0 = {1.3, 3.4, 2.3};

		double tolerance = 0.3;

		int maxIter = 100;

		JacobiIteration ji = new JacobiIteration();
		double[] sol = ji.jacobi_iter(a, x0, b, tolerance, maxIter);

		Matrix.print(sol);

		GaussSeidel gs = new GaussSeidel();
		double[] gsSol = gs.gs_iter(a, x0, b, tolerance, maxIter);

		Matrix.print(gsSol);
	}
}

public class LUDecomposition {
	
	private double[][] l, u, a; //A = LU
	private int m, n;
	private double error;

	public LUDecomposition(double[][] a) {
		this.a = a;
		m = a.length; //rows
		n = a[0].length; //cols
		if(m != n) {
			//error
		}
		//lu_fact();
	}

	public double[][] getL() {
		return l;
	}

	public double[][] getU() {
		return u;
	}

	// public double getError() {
	// 	if (l == null || u == null) {
	// 		//error
	// 	}
	// 	double[][] lu = Matrix.multiplyMatrices(l, u);
	// 	//a is still unchanged
	// 	double[][] aminuslu = Matrix.subtract(lu, a);
	// 	double error = Matrix.norm(aminuslu);
	// 	return error;
	// }

	public void lu_fact() {
		double[][] ident = Matrix.getIdentityMatrix(m, m);
		u = a;
		l = ident;

		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				if(u[j][i] != 0) {
					l[j][i] = u[j][i] / u[i][i];
					for(int k =0; k < n; k++) {
						u[j][k] = u[j][k] + (-1 * l[j][i] * u[i][k]);
					}
				}
			}
		}
	}
}
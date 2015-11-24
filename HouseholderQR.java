
public class HouseholderQR {
	
	private double[][] q, r, a;
	private double error;
	private int m, n;

	public HouseholderQR(double[][] a) {
		if(a == null) {
			//error
		}
		this.a = a;
		m = a.length;
		n = a[0].length;
		if(m != n) {
			//error - only nxn
		}
		//a.qr_fact_househ();
	}

	public double[][] getQ() {
		return q;
	}

	public double[][] getR() {
		return r;
	}

	// public double getError() {
	// 	double[] qr = Matrix.multiplyMatrices(q, r);
	// 	double[] aminusqr = Matrix.subtract(qr, a);
	// 	double error = Matrix.norm(aminusqr);
	// 	return error;
	// }

	public void qr_fact_househ() {
		if(a == null) {
			//error
		}
		double[][] ident = Matrix.getIdentityMatrix(m, m);
		r = a;
		q = ident;
		boolean first = true;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; i < n; i++) {
				if(r[j][i] != 0) {
					int vRows = n-i;
					double[] v = new double[vRows];
					double[][] vident = Matrix.getIdentityMatrix(vRows, vRows);
					for(int k = 0; k+i <n; k++) {
						v[k] = r[i+k][i];
					}
					double norm = Matrix.norm(v);
					double[] u = Matrix.scalarMultiply(1/norm, v);
					double[][] hh = Matrix.multiplyVectors(u, u);
					hh = Matrix.scalarMultiply(2, hh);
					hh = Matrix.subtract(vident, hh);
					for(int l = i; l < n; l++) {
						for(int m = i; m < n; m++) {
							ident[l][m] = hh[l-i][m-i];
						}
					}
					r = Matrix.multiplyMatrices(ident, r);
					if(first) q = ident;
					else q = Matrix.multiplyMatrices(q, ident);

				} else r[j][i] = 0;
			}
		}

	}
}
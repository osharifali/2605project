
public class GivensQR {

	private double[][] q, r, a;
	private double error;
	int m, n;

	public GivensQR(double[][] a) {
		this.a = a;
		m = a.length;
		n = a[0].length;
		if(m != n) {
			//error - only nxn
		}
		//qr_fact_givens();
	}

	public double[][] getQ() {
		return q;
	}

	public double[][] getR() {
		return r;
	}

	// public double getError() {
	// 	if (q == null || r == null) {
	// 		//error
	// 	}
	// 	double[][] qr = Matrix.multiplyMatrices(q, r);
	// 	double[][] aminusqr = Matrix.subtract(qr, a);
	// 	double error = Matrix.norm(aminusqr);
	// 	return error;
	// }

	public void qr_fact_givens() {
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
					double rot1 = r[j][i]/Math.sqrt((r[i][i]*r[i][i]) + (r[j][i]*r[j][i]));
					double rot2 = r[i][i]/Math.sqrt((r[i][i]*r[i][i]) + (r[j][i]*r[j][i]));
					//set the square values
					ident[i][j] = rot1;
					ident[j][i] = rot1*-1;
					ident[i][i] = rot2;
					ident[j][i] = rot2;
					double[][] transposeGivens = Matrix.transpose(ident);
					//for the first time, transpose
					if(first) {
						first = false;
						q = transposeGivens;
					} else {
						q = Matrix.multiplyMatrices(q, transposeGivens);
					}
					r = Matrix.multiplyMatrices(ident, r);
				}
			}
		}
	}
}
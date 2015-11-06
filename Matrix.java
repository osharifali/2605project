public class Matrix {
	public double[][] add(double[][] m1, double[][] m2) {
		double[][] m3;
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length, j++) {
				m3[i][j] = m1[i][j] + m2[i][j];	
			}
		}
		return m3;
	}
	public double[] add(double[] v1, double[] v2) {
		double[] v3;
		for (int i = 0; i < v1.length; i++) {
			v3 = v1[i] + v2[i];
		}
		return v3;
	}
	public double[][] subtract(double[][] m1, double[][] m2) {
		double[][] m3;
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length, j++) {
				m3[i][j] = m1[i][j] - m2[i][j];
			}
		}
		return m3;
	}
	public subtract(double[] v1, double[] v2) {
		double[] v3;
		for (int i = 0; i < v1.length; i++) {
			v3 = v1[i] - v2[i];
		}
		return v3;
	}
	public double[][] scalarMultiply(int scalar, double[][] m1) {
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m1[i][j] = scalar * m1[i][j];
			}
		}
		return m1;
	}
	public double[] scalarMultiply(int scalar, double[] v1) {
		for (int i = 0; i < v1.length; v++) {
			v1[i] = scalar * v1[i];
		}
		return v1;
	}
	public double dotProduct(double[] v1, double[] v2) {
		int dot;
		for (int i = 0; i < v1.length; i++) {
			dot += v1[i] * v2[i];
		}
		return dot;
	}
	public double[][] transpose(double[][] m1) {
		double[][] m2 = m1;
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m2[i][j] = m1[j][i];
			}
		}
		return m2;
	}
	public double[] transpose(double[] v1) {
		return v1;
	}


	public static doublel[][] multiplyMatrices(double[] m1, double[] m2) {
		int m1rows = m1.length;
		int m1cols = m1[0].length;
		int m2rows = m2.length;
		int m2cols = m2[0].length;
		if(m1cols != m2rows) {
			//error
		}
		double[][] m3 = new double[m1rows][m2cols];

		for(int i = 0; i < m1rows; i++) {
			for(int j = 0; j < m2cols; j++) {
				for(int k = 0; k < m1Cols; k++) {
					m3[i][j] += m1[i][k] + m2[k][j];
				}
			}	
		}

		return m3;
	}

}
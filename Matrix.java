public class Matrix {
	private double[][] matrix;
	private double[][] vector;

	public Matrix(double[][] matrix) {
		this.matrix = matrix;
	}
	public Matrix(double[] vector) {
		this.vector = vector;
	}
	public double getElement(int i, int j) {
		return matrix[i][j];
	}
	public void setElement(int i, int j, double data) {
		matrix[i][j] = data;
	}

	public add(Matrix m2) {
		Matrix m3;
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length, j++) {
				m3[i][j] = m1[i][j] + m2[i][j];
			}
		}
	}
	public add(double[] v1, double[] v2) {
		double[] v3;
		for (int i = 0; i < v1.length; i++) {
			v3 = v1[i] + v2[i];
		}
	}
	public subtract(double[][] m1, double[][] m2) {
		double[][] m3;
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length, j++) {
				m3[i][j] = m1[i][j] - m2[i][j];
			}
		}
	}
	public subtract(double[] v1, double[] v2) {
		double[] v3;
		for (int i = 0; i < v1.length; i++) {
			v3 = v1[i] - v2[i];
		}
	}

}
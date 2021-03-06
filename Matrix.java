public class Matrix {

	public static double[][] add(double[][] m1, double[][] m2) {
		double[][] m3 = new double[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m3[i][j] = m1[i][j] + m2[i][j];	
			}
		}
		return m3;
	}

	public static double[] add(double[] v1, double[] v2) {
		double[] v3 = new double[v1.length];
		for (int i = 0; i < v1.length; i++) {
			v3[i] = v1[i] + v2[i];
		}
		return v3;
	}

	public static double[][] subtract(double[][] m1, double[][] m2) {
		double[][] m3 = new double[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m3[i][j] = m1[i][j] - m2[i][j];
			}
		}
		return m3;
	}

	public static double[] subtract(double[] v1, double[] v2) {
		double[] v3 = new double[v1.length];
		for (int i = 0; i < v1.length; i++) {
			v3[i] = v1[i] - v2[i];
		}
		return v3;
	}

	public static double[][] scalarMultiply(int scalar, double[][] m1) {
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m1[i][j] = scalar * m1[i][j];
			}
		}
		return m1;
	}

	public static double[] scalarMultiply(int scalar, double[] v1) {
		for (int i = 0; i < v1.length; i++) {
			v1[i] = scalar * v1[i];
		}
		return v1;
	}

	public static double dotProduct(double[] v1, double[] v2) {
		int dot = 0;
		for (int i = 0; i < v1.length; i++) {
			dot += v1[i] * v2[i];
		}
		return dot;
	}

	public static double[][] transpose(double[][] m1) {
		double[][] m2 = new double[m1[0].length][m1.length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m2[i][j] = m1[j][i];
			}
		}
		return m2;
	}

	public static double[] transpose(double[] v1) {
		return v1;
	}

	public static double determinant(double[][] matrix) {
		double determinant = 0;
        double sign = 1;
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        for (int i = 0; i < matrix.length; i++) {
            int size = matrix.length;
            double[][] subMatrix = new double[size-1][size-1];
            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (k < i) {
                        subMatrix[j-1][k] = matrix[j][k];
                    }
                    else if (k > i) {
                        subMatrix[j-1][k-1] = matrix[j][k];
                    }
                }
            }
            if (i % 2 == 0) {
                sign = 1;
            } else if (i % 2 ==1) {
                sign = -1;
            }
            determinant += sign*matrix[0][i]*(determinant(subMatrix));
        }
        return determinant;
	}



	public static double[][] multiplyMatrices(double[][] m1, double[][] m2) {
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
				for(int k = 0; k < m1cols; k++) {
					m3[i][j] += m1[i][k] * m2[k][j];
				}
			}	
		}

		return m3;
	}

	public static double[][] multiplyVectors(double[] v1, double[] v2) {
		if(v1.length != v2.length) {
			//error
		}
		int vLength = v1.length;
		double[][] m3 = new double[vLength][vLength];
		for(int i = 0; i < vLength; i++) {
			for(int j = 0; j < vLength; j++) {
				m3[i][j] = v1[i] * v2[j];
			}
		}
		return m3;
	}

	public static double[] multiplyMatrixVector(double[] v1, double[][] m1) {
		int vLength = v1.length;
		int m1rows = m1.length;
		int m1cols = m1[0].length;
		if(vLength != m1cols) {
			//error
		}
		double[] m3 = new double[m1rows];
		for(int i = 0; i < m1rows; i++) {
			for(int j = 0; j < m1cols; j++) {
				m3[i] = v1[j] * m1[i][j];
			}
		}
		return m3;
	}
	
	public static double trace(double[][] m){
        double sum = 0;
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                System.out.print(m[row][col] + "\t");
                if(row == col) {
                    sum += m[row][col];

                }
            }
            System.out.println();
        }
        System.out.println(sum);
        return sum;
    }

    public static void print(double[][] m) {
    	for (int i = 0; i < m.length; i++) {
    		for (int j = 0; j < m[0].length; j++) {
    			System.out.print(m[i][j] + "  ");
    		}
    		System.out.println();
    	}
    }

    public static void print(double[] v) {
    	for (int i = 0; i < v.length; i++) {
    		System.out.print(v[i] + "  ");
    	}
    }


}

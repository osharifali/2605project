public class ForwardSub {
    public static double[][] getArrayCopy(double[][] m) {
        double[][] newCopy = new double[getRowDimension(m)][getColumnDimension(m)];
        for(int i = 0;i < newCopy.length; i++) {
            for(int j = 0; j<newCopy[i].length; j++) {
                newCopy[i][j] = m[i][j];
            }
        }
        return newCopy;
    }


    public static double[][] forwardSubstitution(double[][] A, double[][] B) {
        double[][] resultArray = new double[getRowDimension(A)][1];
        double[][] a = getArrayCopy(A);
        double[][] b = getArrayCopy(B);

        for (int j = 0; j < getRowDimension(A); j++) {
            for (int k = 0; k < getColumnDimension(A); k++) {
                if (k == 0 && j == 0) {
                    resultArray[j][0] = b[j][0] / a[j][k];
                } else {
                    if (k == j) {
                        double temp = 0;
                        for (int l = k - 1; l >= 0; l--) {
                            temp = temp + (resultArray[l][0] * a[j][l]);
                        }
                        resultArray[j][0] = (b[k][0] - temp) / a[j][k];
                    }
                }
            }
        }

        for (int i = 0; i < getRowDimension(resultArray); i++) {
            for (int j = 0; j < getColumnDimension(resultArray); j++) {
                System.out.println(getValue(i, j,resultArray));
            }
        }
        return resultArray;
    }

    public static int getColumnDimension(double[][] m) {

        return m[0].length;
    }

    public static int getRowDimension(double[][] m) {

        return m.length;
    }

    public static double getValue(int i, int j, double[][] m) {
        return m[i][j];
    }

    public static void main(String[] args) {
        double [][]test = {
                {4, 0, 0, 0},
                {3, 5, 0, 0},
                {2, 6, 8, 0},
                {1, 5, 3, 6}
        };
        double [][]testB = {
                {1},
                {2},
                {5},
                {8}
        };
        ForwardSub.forwardSubstitution(test, testB);
    }
}

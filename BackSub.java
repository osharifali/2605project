public class BackSub {
    public static double[][] backwardSubstitution(double[][] A, double[][] b) {
        double[][] resultArray = new double[getColumnDimension(A)][1];

        for(int row = getRowDimension(A) -1; row>=0; row--) {
            double pivot = getValue(row,row,A);
            double x = getValue(row,0,b)/pivot;
            for(int i = 0; i < getColumnDimension(A); i++) {
                double mod = 1;
                if(i != row) {
                    if(i != 0 && i < getRowDimension(b)) {
                        mod = getValue(i, 0, resultArray);
                    }
                    x -= mod*getValue(row, i, A) / pivot;
                }
            }
            setValue(row, 0, x, resultArray);

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

    public static void setValue(int i, int j, double val, double[][] m) {
        m[i][j] = val;
    }

    public static void main(String[] args) {
        double [][]test = {
                {1, 5, 3, 6},
                {0,3,5,7},
                {0,0,2,8},
                {0,0,0,4},
        };
        double [][]testB = {
                {1},
                {2},
                {5},
                {8}
        };
        BackSub.backwardSubstitution(test, testB);
    }
}

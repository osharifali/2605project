import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class PowerMethod extends Application{
    static ArrayList<Float> determinants;
    static ArrayList<Float> determinantsInverse;
    static ArrayList<Float> traces;
    static ArrayList<Float> tracesInverse;
    static ArrayList<Float> eigenValues = new ArrayList<>();
    static ArrayList<Float> minEigenValues = new ArrayList<>();
    static ArrayList<float[]> eigenVectors = new ArrayList<>();
    static ArrayList<Integer> numberIterations = new ArrayList<>();
    static ArrayList<Integer> inverseIterations = new ArrayList<>();


    static boolean inverse = false;

    public static Color getColor(int i) {
        if (i < 50) {
            if (i < 25) {
                if (i < 10) {
                    if (i == 1) {
                        return Color.ALICEBLUE;
                    } else if (i == 2) {
                        return Color.ANTIQUEWHITE;
                    } else if (i == 3) {
                        return Color.AQUA;
                    } else if (i == 4) {
                        return Color.AQUAMARINE;
                    } else if (i == 5) {
                        return Color.AZURE;
                    } else if (i == 6) {
                        return Color.BEIGE;
                    } else if (i == 7) {
                        return Color.BISQUE;
                    } else if (i == 8) {
                        return Color.ORANGE;
                    } else if (i == 9) {
                        return Color.BLANCHEDALMOND;
                    }
                } else {
                    if (i == 10) {
                        return Color.BLUE;
                    } else if (i == 11) {
                        return Color.BLUEVIOLET;
                    } else if (i == 12) {
                        return Color.BROWN;
                    } else if (i == 13) {
                        return Color.BURLYWOOD;
                    } else if (i == 14) {
                        return Color.CADETBLUE;
                    } else if (i == 15) {
                        return Color.CHARTREUSE;
                    } else if (i == 16) {
                        return Color.CHOCOLATE;
                    } else if (i == 17) {
                        return Color.CORAL;
                    } else if (i == 18) {
                        return Color.CORNFLOWERBLUE;
                    } else if (i == 19) {
                        return Color.CORNSILK;
                    } else if (i == 20) {
                        return Color.CRIMSON;
                    } else if (i == 21) {
                        return Color.CYAN;
                    } else if (i == 22) {
                        return Color.DARKBLUE;
                    } else if (i == 23) {
                        return Color.DARKCYAN;
                    } else if (i == 24) {
                        return Color.DARKGOLDENROD;
                    }
                }
            } else {
                if (i < 35) {
                    if (i == 25) {
                        return Color.DARKGRAY;
                    } else if (i == 26) {
                        return Color.DARKGREEN;
                    } else if (i == 27) {
                        return Color.DARKGREY;
                    } else if (i == 28) {
                        return Color.DARKKHAKI;
                    } else if (i == 29) {
                        return Color.DARKMAGENTA;
                    } else if (i == 30) {
                        return Color.DARKOLIVEGREEN;
                    } else if (i == 31) {
                        return Color.DARKORANGE;
                    } else if (i == 32) {
                        return Color.DARKORCHID;
                    } else if (i == 33) {
                        return Color.DARKRED;
                    } else if (i == 34) {
                        return Color.DARKSALMON;
                    }
                } else {
                    if (i == 35) {
                        return Color.DARKSEAGREEN;
                    } else if (i == 36) {
                        return Color.DARKSLATEBLUE;
                    } else if (i == 37) {
                        return Color.DARKSLATEGRAY;
                    } else if (i == 38) {
                        return Color.DARKTURQUOISE;
                    } else if (i == 39) {
                        return Color.DARKVIOLET;
                    } else if (i == 40) {
                        return Color.DEEPPINK;
                    } else if (i == 41) {
                        return Color.DEEPSKYBLUE;
                    } else if (i == 42) {
                        return Color.DIMGRAY;
                    } else if (i == 43) {
                        return Color.DODGERBLUE;
                    } else if (i == 44) {
                        return Color.FIREBRICK;
                    } else if (i == 45) {
                        return Color.FLORALWHITE;
                    } else if (i == 46) {
                        return Color.FORESTGREEN;
                    } else if (i == 47) {
                        return Color.FUCHSIA;
                    } else if (i == 48) {
                        return Color.GAINSBORO;
                    } else if (i == 49) {
                        return Color.GHOSTWHITE;
                    }
                }
            }
        } else if (i > 49) {
            if (i < 60) {
                if (i == 50) {
                    return Color.GOLD;
                } else if (i == 51) {
                    return Color.GOLDENROD;
                } else if (i == 52) {
                    return Color.GRAY;
                } else if (i == 53) {
                    return Color.GREEN;
                } else if (i == 54) {
                    return Color.GREENYELLOW;
                } else if (i == 55) {
                    return Color.GREY;
                } else if (i == 56) {
                    return Color.HONEYDEW;
                } else if (i == 57) {
                    return Color.HOTPINK;
                } else if (i == 58) {
                    return Color.INDIANRED;
                } else if (i == 59) {
                    return Color.INDIGO;
                }
            } else if (i >= 60 && i < 70) {
                if (i == 60) {
                    return Color.IVORY;
                } else if (i == 61) {
                    return Color.KHAKI;
                } else if (i == 62) {
                    return Color.LAVENDER;
                } else if (i == 63) {
                    return Color.LAVENDERBLUSH;
                } else if (i == 64) {
                    return Color.LAWNGREEN;
                } else if (i == 65) {
                    return Color.LEMONCHIFFON;
                } else if (i == 66) {
                    return Color.LIGHTBLUE;
                } else if (i == 67) {
                    return Color.LIGHTCORAL;
                } else if (i == 68) {
                    return Color.LIGHTCYAN;
                } else if (i == 69) {
                    return Color.LIGHTGOLDENRODYELLOW;
                }
            } else if (i >= 70 && i < 80) {
                if (i == 70) {
                    return Color.LIGHTGRAY;
                } else if (i == 71) {
                    return Color.LIGHTGREEN;
                } else if (i == 72) {
                    return Color.LIGHTPINK;
                } else if (i == 73) {
                    return Color.LIGHTSALMON;
                } else if (i == 74) {
                    return Color.LIGHTSEAGREEN;
                } else if (i == 75) {
                    return Color.LIGHTSKYBLUE;
                } else if (i == 76) {
                    return Color.LIGHTSLATEGRAY;
                } else if (i == 77) {
                    return Color.LIGHTSTEELBLUE;
                } else if (i == 78) {
                    return Color.LIGHTYELLOW;
                } else if (i == 79) {
                    return Color.LIME;
                }
            } else if (i >= 80 && i < 90) {
                if (i == 80) {
                    return Color.LIMEGREEN;
                } else if (i == 81) {
                    return Color.LINEN;
                } else if (i == 82) {
                    return Color.MAGENTA;
                } else if (i == 83) {
                    return Color.MAROON;
                } else if (i == 84) {
                    return Color.MEDIUMAQUAMARINE;
                } else if (i == 85) {
                    return Color.MEDIUMBLUE;
                } else if (i == 86) {
                    return Color.MEDIUMORCHID;
                } else if (i == 87) {
                    return Color.MEDIUMPURPLE;
                } else if (i == 88) {
                    return Color.MEDIUMSEAGREEN;
                } else if (i == 89) {
                    return Color.MEDIUMSLATEBLUE;
                }
            } else {
                if (i == 90) {
                    return Color.MEDIUMSPRINGGREEN;
                } else if (i == 91) {
                    return Color.MEDIUMTURQUOISE;
                } else if (i == 92) {
                    return Color.MEDIUMVIOLETRED;
                } else if (i == 93) {
                    return Color.MIDNIGHTBLUE;
                } else if (i == 94) {
                    return Color.MINTCREAM;
                } else if (i == 95) {
                    return Color.MISTYROSE;
                } else if (i == 96) {
                    return Color.MOCCASIN;
                } else if (i == 97) {
                    return Color.NAVAJOWHITE;
                } else if (i == 98) {
                    return Color.NAVY;
                } else if (i == 99) {
                    return Color.OLDLACE;
                } else {
                    return Color.OLIVE;
                }
            }
        }
        return Color.BLACK;
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();

        stage.setTitle("Part 3 Plots");
        final NumberAxis xAxis = new NumberAxis(-10, 10, 1);
        final NumberAxis yAxis = new NumberAxis(-10, 10, 1);
        final NumberAxis xAxis2 = new NumberAxis(-10, 10, 1);
        final NumberAxis yAxis2 = new NumberAxis(-10, 10, 1);
        final ScatterChart<Number, Number> scatterchart = new
                ScatterChart<Number, Number>(xAxis, yAxis);

        final ScatterChart<Number, Number> scatterchart2 = new
                ScatterChart<Number, Number>(xAxis2, yAxis2);
        xAxis.setLabel("Determinant of Matrix");
        yAxis.setLabel("Trace of Matrix");
        xAxis2.setLabel("Determinant of Inverse Matrix");
        yAxis2.setLabel("Trace of Inverse Matrix");
        scatterchart.setTitle("Determinant vs. Trace Plot");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Matrix");
        for (int i = 0; i < 1000; i++) {
            XYChart.Data<Number, Number> data = new XYChart.Data(determinants.get(i), traces.get(i));
            Circle point = new Circle(4, getColor(numberIterations.get(i)));
            point.setStroke(Color.BLACK);
            data.setNode(point);
            series1.getData().add(data);
        }

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Inverse Matrix");
        for (int i = 0; i < 1000; i++) {
            XYChart.Data<Number, Number> data = new XYChart.Data(determinantsInverse.get(i), tracesInverse.get(i));
            Circle point = new Circle(4, getColor(inverseIterations.get(i)));
            point.setStroke(Color.BLACK);
            data.setNode(point);
            series2.getData().add(data);
        }

        scatterchart.getData().addAll(series1);
        scatterchart2.getData().addAll(series2);
        HBox hBox1 = new HBox();
        Scene scene = new Scene(new Group());
        hBox1.getChildren().addAll(scatterchart, scatterchart2);
        ((Group)scene.getRoot()).getChildren().add(hBox1);
        stage.setScene(scene);
        stage.show();
    }


    public static void power_method(float[][] matrix, float[] approximation, float tolerance, int maxIterations) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Must be square matrix.");
        }
        if (approximation.length != matrix.length) {
            throw new IllegalArgumentException("Approximation and matrix must be same length.");
        }



        float error = Float.MAX_VALUE;
        float eigenValue = 0;
        float[] unitEigenVector = new float[approximation.length];
        int iterations = 0;

        while (iterations < maxIterations &&  error > tolerance) {

            float[] eigenVector = Matrix.matrixVectorMultiply(matrix, approximation);
            unitEigenVector = Matrix.scale2x2Vector(eigenVector);  //Matrix.normalizeVector(eigenVector);

            float oldEigenValue = eigenValue;
            eigenValue = calculateEigenValue(matrix, eigenVector);



            // calculates error between eigenvalues
            error = Math.abs(eigenValue - oldEigenValue);
            approximation = eigenVector;
            iterations++;
        }

        if (error > tolerance) {
            System.out.println("Failed.");
            if (inverse) {
                inverseIterations.add(iterations);
                minEigenValues.add(1/eigenValue);
            } else {
                eigenVectors.add(unitEigenVector);
                eigenValues.add(eigenValue);
                numberIterations.add(iterations);
            }
            return;
        } else if (inverse) {
            minEigenValues.add(1/eigenValue);
            inverseIterations.add(iterations);

        } else {
            eigenVectors.add(unitEigenVector);
            eigenValues.add(eigenValue);
            numberIterations.add(iterations);
        }

        System.out.println("Number of iterations: " + iterations);


    }

    public static float calculateEigenValue(float[][] matrix, float[] x) {
        float[] temp = Matrix.matrixVectorMultiply(matrix, x);
        return Math.abs((Matrix.dotProduct(temp, x)) / (Matrix.dotProduct(x, x)));

    }

    public static ArrayList<float[][]> create2x2Matrices() {
        ArrayList<float[][]> matrices = new ArrayList<>();
        Random r = new Random();
        float upperBound = 2;
        for (int  k = 0; k < 1000; k++) {
            float[][] temp = new float[2][2];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = r.nextFloat() * ((upperBound * -1) - upperBound) + upperBound;
                }
            }
            matrices.add(temp);
        }
        return matrices;
    }


    public static void main(String[] args) {
        ArrayList<float[][]> matrices = create2x2Matrices();
        ArrayList<float[][]> inverses = new ArrayList<>();

        determinants = new ArrayList<>();
        for (float[][] current: matrices) {
            float determinant = (current[0][0] * current[1][1]) - (current[0][1] * current[1][0]);
            boolean adding = false;
            while (!adding) {
                if (determinant != 0) {
                    inverses.add(Matrix.invert2x2Matrix(current));
                    determinants.add(determinant);
                    adding = true;
                } else {
                    float upperBound = 2;
                    Random r = new Random();
                    for (int i = 0; i < current.length; i++) {
                        for (int j = 0; j < current[0].length; j++) {
                            current[i][j] = r.nextFloat() * ((upperBound * -1) - upperBound) + upperBound;
                        }
                    }
                }
            }
        }

        determinantsInverse = new ArrayList<>();
        for (float[][] current: inverses) {
            float determinant = (current[0][0] * current[1][1]) - (current[0][1] * current[1][0]);
            boolean adding = false;
            while (!adding) {
                if (determinant != 0) {
                    determinantsInverse.add(determinant);
                    adding = true;
                } else {
                    float upperBound = 2;
                    Random r = new Random();
                    for (int i = 0; i < current.length; i++) {
                        for (int j = 0; j < current[0].length; j++) {
                            current[i][j] = r.nextFloat() * ((upperBound * -1) - upperBound) + upperBound;
                        }
                    }
                }
            }
        }


        traces = new ArrayList<>();
        for (float[][] current: matrices) {
            traces.add(Matrix.trace(current));
        }

        tracesInverse = new ArrayList<>();
        for (float[][] current: inverses) {
            tracesInverse.add(Matrix.trace(current));
        }

        float[] approx = {1, 0};

        for (int i = 0; i < 1000; i++) {
            System.out.println("Matrix " + (i+1) + ":");
            Matrix.print(matrices.get(i));
            System.out.println();
            power_method(matrices.get(i), approx, 0.00005f, 100);
            System.out.println("\nDeterminant: " + determinants.get(i) + ", Trace: " + traces.get(i));
            if (Float.isNaN(eigenValues.get(i))) {
                System.out.println("\nMax Eigenvalue is not a real number!");
            } else {
                System.out.println("\nMax Eigenvalue: " + eigenValues.get(i) + ", Eigenvector: " + Arrays.toString(eigenVectors.get(i)));
            }
            System.out.println("----------------------------------------------------");
        }

        for (int i = 0; i < 1000; i++) {
            inverse = true;
            System.out.println("Inverse Matrix " + (i+1) + ":");
            Matrix.print(inverses.get(i));
            System.out.println();
            power_method(inverses.get(i), approx, 0.00005f, 100);
            if (Float.isNaN(minEigenValues.get(i))) {
                System.out.println("\nMinimum Eigenvalue is not a real number!");
            } else {
                System.out.println("\nMin Eigenvalue: " + minEigenValues.get(i));
            }
            System.out.println("----------------------------------------------------");
        }

        launch(args);

    }

}
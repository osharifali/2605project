public class Tester {
	public static void main(String[] args) {
		double[][] one = new double[2][2];
		one[0][0] = 10;
		one[0][1] = 1;
		one[1][0] = 4;
		one[1][1] = 19;
		System.out.println(Matrix.determinant(one));
		Matrix.print(one);
	}
}

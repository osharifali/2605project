public class LUQRTest {
	
		public static void main(String[] args) {

			double[][] alu = {{1.0,1.0,1.0,1.0},
								{1.0, 2.0, 3.0, 4.0},
								{1.0, 3.0, 6.0, 10.0},
								{1.0, 4.0, 10.0, 20.0}};

			LUDecomposition ludecomp = new LUDecomposition(alu);
			ludecomp.lu_fact();
			Matrix.print(ludecomp.getL());
			System.out.println("hiiiiii");
			Matrix.print(ludecomp.getU());
			//System.out.println("err: " + error);

			GivensQR gqr = new GivensQR(alu);
			gqr.qr_fact_givens();
			Matrix.print(gqr.getQ());
			System.out.println("hiiiiii");
			Matrix.print(gqr.getR());
	}
}
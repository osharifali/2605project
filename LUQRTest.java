public class LUQRTest {
	
		public static void main(String[] args) {

			double[][] alu = {{1.0,1.0,1.0,1.0},
								{1.0, 2.0, 3.0, 4.0},
								{1.0, 3.0, 6.0, 10.0},
								{1.0, 4.0, 10.0, 20.0}};

			System.out.println("LU: ");
			LUDecomposition ludecomp = new LUDecomposition(alu);
			ludecomp.lu_fact();
			Matrix.print(ludecomp.getL());
			System.out.println("--------");
			Matrix.print(ludecomp.getU());
			// System.out.println("err: " + ludecomp.getError());

			System.out.println("Givens QR: ");
			GivensQR gqr = new GivensQR(alu);
			gqr.qr_fact_givens();
			Matrix.print(gqr.getQ());
			System.out.println("--------");
			Matrix.print(gqr.getR());
			// System.out.println("err: " + gqr.getError());

			System.out.println("HH QR: ");
			HouseholderQR hhqr = new HouseholderQR(alu);
			hhqr.qr_fact_househ();
			Matrix.print(hhqr.getQ());
			System.out.println("--------");
			Matrix.print(hhqr.getR());
			// System.out.println("err: " + hhqr.getError());
	}
}
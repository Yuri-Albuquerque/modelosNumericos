package modelo.numerico;
import org.apache.commons.math.linear.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Multiplicação de matrizes");
        double[][] matrixData = { {1d,2d,3d}, {2d,5d,3d}};
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

        double[][] matrixData2 = { {1d,2d}, {2d,5d}, {1d, 7d}};
        RealMatrix n = new Array2DRowRealMatrix(matrixData2);

        RealMatrix p = m.multiply(n);

        System.out.println(p.getRowDimension());    //2
        System.out.println(p.getColumnDimension()); //2
        System.out.println(p);

        // Invertendo a matriz p usando a decomposição LU

        RealMatrix pInverse = new LUDecomposition(p).getL();
}

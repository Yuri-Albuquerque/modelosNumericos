package modelo.numerico;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.commons.math.linear.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        System.out.println("Multiplicação de matrizes");
        double[][] matrixData = {{1d, 2d, 3d}, {2d, 5d, 3d}};
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

        double[][] matrixData2 = {{1d, 2d}, {2d, 5d}, {1d, 7d}};
        RealMatrix n = new Array2DRowRealMatrix(matrixData2);

        RealMatrix p = m.multiply(n);

        System.out.println(p.getRowDimension());    //2
        System.out.println(p.getColumnDimension()); //2
        System.out.println(p);

        // Invertendo a matriz p usando a decomposição LU

      RealMatrix pInverse = new LUDecompositionImpl(p).getSolver().getInverse();
        System.out.println(pInverse);

        RealMatrix coeficientes = new Array2DRowRealMatrix(new double[][]{{2,3,-2}, {-1,7,6}, {4,-3,-5}},false);

        DecompositionSolver decompostaQR = new QRDecompositionImpl(coeficientes).getSolver();

        RealVector contantes = new ArrayRealVector(new double[]{1,-2,1}, false);

        RealVector solucao = decompostaQR.solve(contantes);
        double[][] Q = new QRDecompositionImpl(coeficientes).getQ().getData();


        RealMatrix R = new QRDecompositionImpl(coeficientes).getR();
        System.out.println("----------------------------------------");
        PrintStream saida = new PrintStream(new FileOutputStream("dados_de_saida.txt"));
        System.setOut(saida);
        for (int i = 0; i <= 2; i++){
            for(int j = 0; j<=2; j++){
//                System.out.println("Matriz Q "+Q[i][j]);
                saida.println(Q[i][j]+"\n");

            }
        }
        System.out.println("Matriz R"+R);
        System.out.println("----------------------------------------");
        System.out.println(solucao);

    }
}

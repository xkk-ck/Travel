package cn.itcast.travel.util;
import cn.itcast.travel.domain.Matrix;

public class ComputeUtils {
    public Matrix inputMatrix(Matrix matrix) {

        int row = matrix.getRow();
        int col = matrix.getCol();
        //set value
        double[][] value= matrix.getValue();
        System.out.println(value);


        double data[][] = new double[row][col];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                double d = value[i][j];

                data[i][j] = d;

            }
        }
        matrix.setValue(data);
        return matrix;
    }
}

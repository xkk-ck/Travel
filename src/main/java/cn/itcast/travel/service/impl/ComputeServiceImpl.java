package cn.itcast.travel.service.impl;
import cn.itcast.travel.domain.Matrix;

public  class ComputeServiceImpl {

    public static double[][] getArray(String row, String col,String value){
        double[][] sums = new double[Integer.parseInt(row)][Integer.parseInt(col)];//要保证row col非空
        int rows = 0; //行
        int cols = 0; //列
        int vaLenth = value.length();//字符串长度
        for (int i = 0; i < vaLenth; i++) {  //遍历字符串
            char chara = value.charAt(i);
            if (chara!='['&&chara!=']'&&(chara!=','||chara!='，')){
                sums[rows][cols] = Double.parseDouble(chara+"");
                cols++;
            }
            if (chara==']'&&i!=vaLenth-1) {
                rows++;
                cols=0;
            }
        }
        return sums;
    }
    /**
     * 矩阵的相加
     */
    public Matrix matrixAdd(Matrix matrix_a, Matrix matrix_b){
            int row = matrix_a.getRow();
            int col = matrix_a.getCol();
            double matrix_a_val[][] = matrix_a.getValue();
            double matrix_b_val[][] = matrix_b.getValue();
            double matrix_val[][] = new double[row][col];
            Matrix matrix = new Matrix(row, col,matrix_val);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_val[i][j] = matrix_a_val[i][j] + matrix_b_val[i][j];
                }
            }
            matrix.setValue(matrix_val);
            return matrix;
    }
    /**
     * 矩阵的相乘
     */
    public Matrix matrixMultiply(Matrix matrix_a, Matrix matrix_b)  {
        int row = matrix_a.getRow();
        int col = matrix_b.getCol();
        int roco = matrix_a.getCol();
        double matrix_a_val[][] = matrix_a.getValue();
        double matrix_b_val[][] = matrix_b.getValue();
        double matrix_val[][] = new double[row][col];
        Matrix matrix = new Matrix(row, col,matrix_val);
        if (matrix_a.getCol() != matrix_b.getRow()) {
          return matrix=null;
        }else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_val[i][j] = 0;
                    for (int k = 0; k < roco; k++) {
                        matrix_val[i][j] = matrix_val[i][j] + matrix_a_val[i][k] * matrix_b_val[k][j];
                    }
                }
            }
            matrix.setValue(matrix_val);
            return matrix;
        }
    }


}

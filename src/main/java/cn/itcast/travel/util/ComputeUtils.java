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


}

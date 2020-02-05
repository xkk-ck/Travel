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

                if (chara!='['&&chara!=']'&&(chara!=','&&chara!='，')){

                    if (chara=='-') {
                        String ss=value.substring(i, i+2);
                        i=i+2;
                        sums[rows][cols] = Double.parseDouble(ss);
                        cols++;
                    }else{

                        sums[rows][cols] = Double.parseDouble(chara+"");
                        cols++;
                    }
                }
                    if (chara==']'&&i!=vaLenth-1) {
                        rows++;
                        cols=0;
                    }

        }
        return sums;
    }

    /**
     * 矩阵初等变换为最简行阶梯形矩阵
     */
    public Matrix matrixStep(Matrix matrix) {
        int row = matrix.getRow();
        int col = matrix.getCol();
        double value[][] = matrix.getValue();
        value = simplify(0, 0, row, col, value);
        value = simplify_M(row - 1, row, col, value);
        Matrix matrix_S = new Matrix(row, col,value);
//        matrix_S.setValue(value);
        return matrix_S;
    }

    /**
     * 初等变换为行阶梯行矩阵具体过程
     */
    public double[][] simplify(int x,int y,int row,int col,double value[][]) {
        double temp;
        if(x < row && y < col) {
            if(value[x][y] == 0) {
                // 化简的开始位置的值为零
                for(int i = x + 1;i < row;i++) {
                    if(value[i][y] != 0) {
                        // 化简的位置以下的元素不为零时，交换两行元素，再递归
                        for(int j = y;j < col;j++) {
                            temp = value[i][j];
                            value[i][j] = value[x][j];
                            value[x][j] = temp;
                        }
                        System.out.println(1);                                  // 1
                        for(int m = 0;m < value.length;m++) {
                            for(int n = 0;n < value[m].length;n++) {
                                System.out.print(value[m][n] + "    ");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        return simplify(x, y, row, col, value);
                    }
                }
                // 化简的开始位置以下的元素全为零时，向右移一位，再递归
                System.out.println(2);			                              // 2
                for(int m = 0;m < value.length;m++) {
                    for(int n = 0;n < value[m].length;n++) {
                        System.out.print(value[m][n] + "    ");
                    }
                    System.out.println();
                }
                System.out.println();
                return simplify(x, y + 1, row, col, value);
            }else {
                //化简的开始位置元素不为零时
                if(value[x][y] != 1) {
                    //化简开始位置不等于1，判断下面的元素是否存在1，存在，则交换,递归
                    for(int i = x + 1;i < row;i++) {
                        if(value[i][y] == 1) {
                            for(int j = y;j < col;j++) {
                                temp = value[i][j];
                                value[i][j] = value[x][j];
                                value[x][j] = temp;
                            }
                            System.out.println(3);                         // 3
                            for(int m = 0;m < value.length;m++) {
                                for(int n = 0;n < value[m].length;n++) {
                                    System.out.print(value[m][n] + "    ");
                                }
                                System.out.println();
                            }
                            System.out.println();
                            return simplify(x, y, row, col, value);
                        }
                    }
                }

                // 开始位置的下面的元素都不为1，则进行化简
                double divisor = value[x][y];
                for(int i = y;i < col;i++) {
                    value[x][i] /= divisor;
                }
                for(int j = x + 1;j < row;j++) {
                    divisor = value[j][y];
                    for(int k = y;k < col;k++) {
                        value[j][k] -= (divisor * value[x][k]);
                    }
                }
                System.out.println(4);				                      // 4
                for(int m = 0;m < value.length;m++) {
                    for(int n = 0;n < value[m].length;n++) {
                        System.out.print(value[m][n] + "    ");
                    }
                    System.out.println();
                }
                System.out.println();
                return simplify(x + 1, y + 1, row, col, value);
            }

        }else {
            for(int m = 0;m < value.length;m++) {
                for(int n = 0;n < value[m].length;n++) {
                    System.out.print(value[m][n] + "    ");
                }
                System.out.println();
            }
            System.out.println();
            return value;
        }
    }

    /**
     * 行阶梯形矩阵转换为最简行阶梯形矩阵
     * 从最后一行依次向上，找首元，化简
     */
    public double[][] simplify_M(int x,int row,int col,double value[][]){

        System.out.println("row == " + value.length);
        System.out.println("col == " + value[0].length);

        // 行数大于等于0;
        if(x >= 0) {
            System.out.println("x == " + x);
            // 从开始位置向右遍历，找到首元
            for(int i = 0;i < col;i++) {
                System.out.println("i == " + i);
                if(value[x][i] != 0) {
                    // 找到首元
                    double multiple;
                    //首元所在列的元素遍历，不为0则化简
                    for(int j = 0;j < x;j++) {
                        System.out.println("j == " + j);
                        if(value[j][i] != 0) {
                            multiple = value[j][i];
                            for(int k = 0;k < col;k++) {
                                System.out.println("k == " + k);
                                value[j][k] -= (multiple * value[x][k]);
                            }
                        }
                    }

                    System.out.println(11);                         // 11
                    for(int m = 0;m < value.length;m++) {
                        for(int n = 0;n < value[m].length;n++) {
                            System.out.print(value[m][n] + "    ");
                        }
                        System.out.println();
                    }
                    System.out.println();


                    return simplify_M(x - 1, row, col, value);
                }
            }

            System.out.println(12);                         // 12
            for(int m = 0;m < value.length;m++) {
                for(int n = 0;n < value[m].length;n++) {
                    System.out.print(value[m][n] + "    ");
                }
                System.out.println();
            }
            System.out.println();


            // 循环结束，未找到首元，即这一行全为零
            return simplify_M(x - 1, row, col, value);

        }
        else {

            System.out.println(13);                         // 13
            for(int m = 0;m < value.length;m++) {
                for(int n = 0;n < value[m].length;n++) {
                    System.out.print(value[m][n] + "    ");
                }
                System.out.println();
            }
            System.out.println();


            return value;
        }
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
    /**
     * 矩阵的转置
     */
    public Matrix matrixTranspose(Matrix matrix) {

            int row = matrix.getCol();
            int col = matrix.getRow();
            double matrix_T_value[][] = new double[row][col];
            Matrix matrix_T = new Matrix(row, col,matrix_T_value);
            double matrix_value[][] = matrix.getValue();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_T_value[i][j] = matrix_value[j][i];
                }
            }
            matrix_T.setValue(matrix_T_value);
            return matrix_T;

    }
    /**
     * 逆矩阵
     */

    public Matrix matrixInverse(Matrix matrix) {
        int row = matrix.getRow();
        int col = matrix.getCol();
        double[][] value = matrix.getValue();
        double[][] value_E = new double[row][row];
        double[][] value_C = new double[row][col + row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (i == j) {
                    value_E[i][j] = 1;
                } else {
                    value_E[i][j] = 0;
                }
            }
        }
        Matrix matrix_C = new Matrix(row, col + row,value_C);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col + row; j++) {
                if (j < col) {
                    value_C[i][j] = value[i][j];
                } else {
                    value_C[i][j] = value_E[i][j - col];
                }
            }
        }
        matrix_C.setValue(value_C);
        Matrix matrix_EI = matrixStep(matrix_C);
        double[][] value_I = new double[row][col];
        Matrix matrix_I = new Matrix(row, col,value_I);
        double value_EI[][] = matrix_EI.getValue();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                value_I[i][j] = value_EI[i][j + row];
                System.out.print(value_I[i][j] + "     ");
            }
            System.out.println();
        }
        matrix_I.setValue(value_I);
        return matrix_I;
    }

    /**
     * 矩阵的秩
     *
     */
    public int matrixRank(Matrix matrix) {
        int row = matrix.getRow();
        int col = matrix.getCol();
        Matrix matrix_S = matrixStep(matrix);
        double value[][] = matrix_S.getValue();
        System.out.println();
        int i = 0, j = 0, rank = 0;
        while (i < row && j < col) {
            double temp = value[i][j];
            if (temp == 1) {
                i++;
                j++;
                rank++;
            }
            if (temp == 0) {
                j++;
            }
        }
        return rank;
    }

    /**
     * 行列式的值
     * 将行列式装换为上三角行列式topTriangle() 再求对角线的乘积
     */
    public double determinant(Matrix matrix) {
        int row = matrix.getRow();
        int col = matrix.getCol();
        double product = 1;
        double value[][] = topTraiangle(0, 0, row, col, matrix.getValue());
        for (int i = 0; i < row; i++) {
            product *= value[i][i];
        }
        return product;
    }

    /**
     * 行列式转换为上三角行列式，以此求行列式的值
     *
     */
    public double[][] topTraiangle(int x, int y, int row, int col, double value[][]) {
        double temp;
        if (x < row && y < col) {
            if (value[x][y] == 0) {
                // 化简的开始位置的值为零
                for (int i = x + 1; i < row; i++) {
                    if (value[i][y] != 0) {
                        // 化简的位置以下的元素不为零时，交换两行元素，再递归
                        for (int j = y; j < col; j++) {
                            temp = value[i][j];
                            value[i][j] = value[x][j];
                            value[x][j] = -temp;
                        }
                        System.out.println(1); // 1
                        for (int m = 0; m < value.length; m++) {
                            for (int n = 0; n < value[m].length; n++) {
                                System.out.print(value[m][n] + "    ");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        return topTraiangle(x, y, row, col, value);
                    }
                }
                // 化简的开始位置以下的元素全为零时，向右移一位，再递归
                System.out.println(2); // 2
                for (int m = 0; m < value.length; m++) {
                    for (int n = 0; n < value[m].length; n++) {
                        System.out.print(value[m][n] + "    ");
                    }
                    System.out.println();
                }
                System.out.println();
                return topTraiangle(x, y + 1, row, col, value);
            } else {
                double divisor;
                for (int j = x + 1; j < row; j++) {
                    divisor = value[j][y] / value[x][y];
                    for (int k = y; k < col; k++) {
                        value[j][k] -= (divisor * value[x][k]);
                    }
                }
                System.out.println(3); // 3
                for (int m = 0; m < value.length; m++) {
                    for (int n = 0; n < value[m].length; n++) {
                        System.out.print(value[m][n] + "    ");
                    }
                    System.out.println();
                }
                System.out.println();
                return topTraiangle(x + 1, y + 1, row, col, value);
            }

        } else {
            System.out.println(4); // 4
            for (int m = 0; m < value.length; m++) {
                for (int n = 0; n < value[m].length; n++) {
                    System.out.print(value[m][n] + "    ");
                }
                System.out.println();
            }
            System.out.println();
            return value;
        }
    }

    /**
     * 齐次线性方程组的解
     */

    public Matrix equationsSolution(Matrix matrix) {
        Matrix matrix_M = matrixStep(matrix);
        int row = matrix.getRow();
        int col = matrix.getCol();
        int rank = matrixRank(matrix); // 矩阵的秩
        int[][] index = new int[rank][2]; // 保存首元所在位置
        double[][] value_M = matrix_M.getValue();
        int i = 0, j = 0, k = 0;
        while (i < row && j < col) {
            double temp = value_M[i][j];
            if (temp == 1) {
                index[k][0] = i;
                index[k++][1] = j;
                i++;
                j++;
            }
            if (temp == 0) {
                j++;
            }
        }

        for (int m = 0; m < value_M.length; m++) {
            for (int n = 0; n < value_M[0].length; n++) {
                System.out.print(value_M[m][n] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        // 将方程组的解以矩阵的形式存储
        int matrix_ES_row = col;           // 解矩阵的行等于系数矩阵的列
        int matrix_ES_col = col - rank;    // 解矩阵的列等于系数矩阵的列减去矩阵的秩
        double[][] value_ES = new double[matrix_ES_row][matrix_ES_col];
        Matrix matrix_ES = new Matrix(matrix_ES_row, matrix_ES_col,value_ES);

        // 对最简行阶梯形矩阵遍历
        int flag,x,y = 0,isEmpty = 1;
        k = 0;
        for(i = 0;i < row;i++) {
            flag = 0;
            x = 0;
            for(j = 0;j < col;j++) {
                System.out.println(i + "   " + j);
                if(k < index.length && i == index[k][0] && j == index[k][1]) {
                    // 如果为首元，则标记，并且记录下首元列的位置，存储首元位置数组向下跳
                    y = j;
                    k++;
                    flag = 1;
                    System.out.println("找到首元");
                }
                if(flag == 1 && (j != y) && value_M[i][j] != 0) {
                    // 若已找到首元，且该位置元素不为首元,不等于0
                    System.out.println(y + "   " + x + "   " + value_M[i][j]);
                    value_ES[y][x++] = -value_M[i][j];
                    isEmpty = 0;
                }
            }
        }
        k = 0;
        flag = 0;
        for(i = 0;i < matrix_ES_row;i++) {
            flag = 0;
            for(j = 0;j < index.length;j++) {
                if(i == index[j][1]) {
                    flag = 1;
                }
            }
            if(flag == 0) {
                value_ES[i][k] = 1;
                k++;
            }
        }
        if(isEmpty == 1) {
            matrix_ES_row = row;
            matrix_ES_col = 1;
            value_ES = new double[row][1];
            matrix_ES = new Matrix(matrix_ES_row, matrix_ES_col,value_ES);

            for (int m = 0; m < matrix_ES_row; m++) {
                for (int n = 0; n < matrix_ES_col; n++) {
                    value_ES[m][n] = 0;
                }
            }
        }
        System.out.println();
        for (int m = 0; m < matrix_ES_row; m++) {
            for (int n = 0; n < matrix_ES_col; n++) {
                System.out.print(value_ES[m][n] + "  ");
            }
            System.out.println();
        }
        matrix_ES.setValue(value_ES);
        return matrix_ES;
    }


    /**
     * 非齐次线性方程组的解
     * 传入的参数为增广矩阵
     * 将增广矩阵化简为行最简阶梯形矩阵
     * 拆分出系数矩阵
     * 对系数矩阵求解，最后添加行最简阶梯形矩阵的最后一列
     */

    public Matrix unequationsSolution(Matrix augmentMatrix) {
        Matrix augmentMatrix_M = matrixStep(augmentMatrix);    // 增广矩阵的行最简阶梯形矩阵
        int augmentMatrix_row = augmentMatrix.getRow();
        int augmentMatrix_col = augmentMatrix.getCol();

        int coefficientMatrix_row = augmentMatrix_row;    // 系数矩阵的行数为增广矩阵的列数
        int coefficientMatrix_col = augmentMatrix_col - 1;// 系数矩阵的列数为增广矩阵的列数减1

        double[][] value_AM = augmentMatrix_M.getValue();
        double[][] value_CM = new double[coefficientMatrix_row][coefficientMatrix_col];

        for(int i = 0;i < coefficientMatrix_row;i++) {
            for(int j = 0;j < coefficientMatrix_col;j++) {
                value_CM[i][j] = value_AM[i][j];
            }
        }

        Matrix coeffcientMatrix = new Matrix(coefficientMatrix_row, coefficientMatrix_col,value_CM);
//        coeffcientMatrix.setValue(value_CM);


        int augmentMatrix_rank = matrixRank(augmentMatrix);        // 增广矩阵的秩
        int coefficientMatrix_rank = matrixRank(coeffcientMatrix); // 系数矩阵的秩

        if(coefficientMatrix_rank < augmentMatrix_rank) {
            System.out.println("无解");
            // 系数矩阵的秩小于增广矩阵的秩，无解
            return null;
        }


        // 对系数矩阵求解
        int[][] index = new int[coefficientMatrix_rank][2];      // 保存首元所在位置
        int i = 0, j = 0, k = 0;
        while (i < coefficientMatrix_row && j < coefficientMatrix_col) {
            double temp = value_CM[i][j];
            if (temp == 1) {
                index[k][0] = i;
                index[k++][1] = j;
                i++;
                j++;
            }
            if (temp == 0) {
                j++;
            }
        }

        // 将方程组的解以矩阵的形式存储
        int matrix_ES_row = coefficientMatrix_col;           // 解矩阵的行等于系数矩阵的列
        int matrix_ES_col = coefficientMatrix_col - coefficientMatrix_rank + 1;    // 解矩阵的列等于系数矩阵的列减去矩阵的秩
        double[][] value_ES = new double[matrix_ES_row][matrix_ES_col];
        Matrix matrix_ES = new Matrix(matrix_ES_row, matrix_ES_col,value_ES);

        // 对最简行阶梯形矩阵遍历
        int flag,x,y = 0,isEmpty = 1;
        k = 0;
        for(i = 0;i < coefficientMatrix_row;i++) {
            flag = 0;
            x = 0;
            for(j = 0;j < coefficientMatrix_col;j++) {
                System.out.println(i + "   " + j);
                if(k < index.length && i == index[k][0] && j == index[k][1]) {
                    // 如果为首元，则标记，并且记录下首元列的位置，存储首元位置数组向下跳
                    y = j;
                    k++;
                    flag = 1;
                    System.out.println("找到首元");
                }
                if(flag == 1 && (j != y) && value_CM[i][j] != 0) {
                    // 若已找到首元，且该位置元素不为首元,不等于0
                    System.out.println(y + "   " + x + "   " + value_CM[i][j]);
                    value_ES[y][x++] = -value_CM[i][j];
                    isEmpty = 0;
                }
            }
        }

        k = 0;
        flag = 0;
        for(i = 0;i < matrix_ES_row;i++) {
            flag = 0;
            for(j = 0;j < index.length;j++) {
                if(i == index[j][1]) {
                    flag = 1;
                }
            }
            if(flag == 0) {
                value_ES[i][k] = 1;
                k++;
            }
        }
        if(isEmpty == 1) {
            matrix_ES_row = coefficientMatrix_row;
            matrix_ES_col = 1;
            value_ES = new double[coefficientMatrix_row][1];
            matrix_ES = new Matrix(matrix_ES_row, matrix_ES_col,value_ES);

            for (int m = 0; m < matrix_ES_row; m++) {
                value_ES[m][0] = value_AM[m][augmentMatrix_col - 1];
            }
        }
        System.out.println();

        System.out.println(augmentMatrix_col);
        for(int m =0;m < matrix_ES_row;m++) {
            System.out.println("m == " + m);
            if(m < coefficientMatrix_row) {
                value_ES[m][matrix_ES_col - 1] = value_AM[m][augmentMatrix_col - 1];
            }else {
                value_ES[m][matrix_ES_col - 1] = 0;
            }
        }

        System.out.println();
        for (int m = 0; m < matrix_ES_row; m++) {
            for (int n = 0; n < matrix_ES_col; n++) {
                System.out.print(value_ES[m][n] + "  ");
            }
            System.out.println();
        }
        matrix_ES.setValue(value_ES);

        return matrix_ES;
    }
    /**
     *向量组线性相关的判断
     *
     */
    public boolean isCorrelate(Matrix matrix) {
        int col = matrix.getCol();
        int rank = matrixRank(matrix);
        if(rank < col) {
            return true;
        }
        return false;
    }

    /**
     *矩阵合并
     *将一个矩阵接于另一个矩阵之后
     */

    public Matrix MatrixCombine(Matrix matrix1,Matrix matrix2) {
        int matrix1_row = matrix1.getRow();
        int matrix1_col = matrix1.getCol();

        int matrix2_col = matrix2.getCol();

        int matrix3_row = matrix1_row;
        int matrix3_col = matrix1_col + matrix2_col;

        double[][] value1 = matrix1.getValue();
        double[][] value2 = matrix2.getValue();
        double[][] value3 = new double[matrix3_row][matrix3_col];

        Matrix matrix3 = new Matrix(matrix3_row, matrix3_col,value3);

        for(int i = 0;i < matrix3_row;i++) {
            for(int j = 0;j < matrix3_col;j++) {
                if(j < matrix1_col) {
                    value3[i][j] = value1[i][j];
                }else {
                    value3[i][j] = value2[i][j - matrix1_col];
                }
            }
        }
        matrix3.setValue(value3);

        return matrix3;
    }





}

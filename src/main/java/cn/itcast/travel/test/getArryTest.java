package cn.itcast.travel.test;

import cn.itcast.travel.domain.Matrix;
import cn.itcast.travel.service.impl.ComputeServiceImpl;

public class getArryTest {
    ComputeServiceImpl computeService = new ComputeServiceImpl();
    public static void main(String[] args) {
        String Date = "[[1,2][3,4]]";
        Matrix matrix = new Matrix(2, 2, ComputeServiceImpl.getArray("2", "2", Date));
        System.out.println(matrix);

    }
}

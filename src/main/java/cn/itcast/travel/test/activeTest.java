package cn.itcast.travel.test;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import java.lang.reflect.Array;
import java.util.Arrays;

public class activeTest {
    public static void main(String[] args) {
//        String code = "b743b2d88aeb42ca939af2e890f2abd5";
//        if (code != null){
////       2.调用service完成激活
//            UserService service = new UserServiceImpl();
//            boolean flag = service.active(code);
//
////        3.判断标记
//            String msg = null;
//            if (flag) {
////        激活成功
//                msg = "激活成功，请<a href='login.html'>登录</a>";
//            }else{
////        激活失败
//                msg = "激活失败，请联系管理员！";
//            }
//            System.out.println(msg);


//        double[][] array = new double[3][5];
//        array[1][1]=4;
//        array[1][1]=2;
//        array[1][1]=3;
//        System.out.println(Arrays.toString(array));

//        double[][] array = getArray("3", "3", "[[1,3,3],[1,2,2],[1,1,1]]");
//        System.out.println(array[1][2]);

        }


//    public static double[][] getArray(String row, String col,String value){
//        double[][] sums = new double[Integer.parseInt(row)][Integer.parseInt(col)];//要保证row col非空
//        int rows = 0; //行
//        int cols = 0; //列
//        int vaLenth = value.length();//字符串长度
//        for (int i = 0; i < vaLenth; i++) {  //遍历字符串
//            char chara = value.charAt(i);
//            if (chara!='['&&chara!=']'&&chara!=','){
//                sums[rows][cols] = Double.parseDouble(chara+"");
//                cols++;
//            }
//            if (chara==']'&&i!=vaLenth-1) {
//                rows++;
//                cols=0;
//            }
//            continue;
//        }
//        return sums;
//    }
}

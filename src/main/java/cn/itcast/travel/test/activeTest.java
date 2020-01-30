package cn.itcast.travel.test;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

public class activeTest {
    public static void main(String[] args) {
        String code = "b743b2d88aeb42ca939af2e890f2abd5";
        if (code != null){
//       2.调用service完成激活
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);

//        3.判断标记
            String msg = null;
            if (flag) {
//        激活成功
                msg = "激活成功，请<a href='login.html'>登录</a>";
            }else{
//        激活失败
                msg = "激活失败，请联系管理员！";
            }
            System.out.println(msg);

        }
    }
}

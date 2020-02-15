package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Admin;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.service.AdminService;
import cn.itcast.travel.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/adminServlet/*")
public class AdminServlet extends BaseServlet {
    private AdminService service = new AdminServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取用户名和密码数据
        Map<String,String[]> map = request.getParameterMap();
//        2.封装Admin对象
        Admin admin = new Admin();
        try {
            BeanUtils.populate(admin,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        3.调用Service查询

        Admin a = service.login(admin);

        ResultInfo info = new ResultInfo();

//        4.判断用户对象是否为null
        if (a == null){
//            用户名密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }else{
            info.setFlag(true);
            request.getSession().setAttribute("Admin",a);

        }

//        响应数据
     writeValue(info,response);
    }

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pagesize");

        int currentPage = 0; //当前页码，如果不传，则默认显示第一页
        if (currentPageStr != null &&currentPageStr.length()>0){
            currentPage = Integer.parseInt(currentPageStr);
        }else{
            currentPage = 1;
        }
        int pageSize = 0; //每页显示条数，如果不传，则默认显示5条
        if (pageSizeStr != null &&pageSizeStr.length()>0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else{
            pageSize = 5;
        }
//        3.调用service查询PageBean对象

        PageBean pb = service.pageQuery(currentPage,pageSize);


//        4.将PageBean对象序列化为JSON，返回
        writeValue(pb,response);

    }
    public void frozenuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       1.获取激活码
        String uid = request.getParameter("uid");

        ResultInfo info = new ResultInfo();
        if (uid != null){
//       2.调用service完成激活
            service.frozenuser(Integer.parseInt(uid));
            info.setFlag(true);
            info.setErrorMsg("冻结成功");
            }else{
//        失败
            info.setFlag(false);
            info.setErrorMsg("冻结失败");
            }
           writeValue(info,response);

    }

    public void delectquestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       1.获取激活码
        String id = request.getParameter("id");

        ResultInfo info = new ResultInfo();
        if (id != null){
//       2.调用service完成激活
            service.delectquestion(Integer.parseInt(id));
            info.setFlag(true);
            info.setErrorMsg("删除成功");
        }else{
//        失败
            info.setFlag(false);
            info.setErrorMsg("删除失败");
        }
        writeValue(info,response);

    }
    
}

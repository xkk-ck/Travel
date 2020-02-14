package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Question;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.QuestionService;
import cn.itcast.travel.service.impl.QuestionServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/questionServlet/*")
public class QuestionServlet extends BaseServlet {
    private QuestionService service = new QuestionServiceImpl();
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        从session中获取用户名
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("user");
        String username = u.getUsername();

        ResultInfo info = new ResultInfo();
//        比较
        if (username == null){
//        验证码错误
//            注册失败
            info.setFlag(false);
            info.setErrorMsg("还未登录，您请登录后再操作");

        }else{
            //       1.获取数据
            Map<String,String[]> map = request.getParameterMap();
//       2.封装对象
            Question question = new Question();
            question.setUsername(username);
            //        设置时间
            String datestyle="yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat format=new SimpleDateFormat(datestyle);
            Date time=new Date();
            String nowtime=format.format(time);
            question.setTime(nowtime);


            try {
                BeanUtils.populate(question,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
//       3.调用service完成提问
            service.post(question);
//            注册成功
                info.setFlag(true);
            }
//        将info对象序列化
//        将JSON数据写回客户端，设置content-type

            writeValue(info,response);

        }

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pagesize");
//        String cidStr = request.getParameter("cid");

//        int cid = 0; //类别id
//        2.处理参数
//        if (cidStr != null && cidStr.length()>0){
//            cid = Integer.parseInt(cidStr);
//        }
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
        }


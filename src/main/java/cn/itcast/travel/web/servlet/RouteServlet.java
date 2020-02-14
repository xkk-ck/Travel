package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/routeServlet/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pagesize");
        String cidStr = request.getParameter("cid");

        int cid = 0; //类别id
//        2.处理参数
        if (cidStr != null && cidStr.length()>0){
            cid = Integer.parseInt(cidStr);
        }
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

        PageBean pb = routeService.pageQuery(cid,currentPage,pageSize);


//        4.将PageBean对象序列化为JSON，返回
        writeValue(pb,response);

    }

}

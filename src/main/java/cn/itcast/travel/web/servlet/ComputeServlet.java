package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Matrix;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.service.impl.ComputeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/computeServlet/*")
public class ComputeServlet extends BaseServlet {

    ComputeServiceImpl computeServiceImpl = new ComputeServiceImpl();


    public void matrixAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");
        System.out.println("row:" + row);
        String col = request.getParameter("col");
        System.out.println("col" + col);
        String Date = request.getParameter("Date");
        System.out.println("Date"+Date);
        String Date2 = request.getParameter("Date2");
        System.out.println("Date2"+Date2);
//        System.out.println("Date:" + Date);
//        if (row!=null&&col!=null&&Date!=null) {
//            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
//            System.out.println(matrix.toString());
//            System.out.println(matrix.getValue().length);
//        }
//        if (row!=null&&col!=null&&Date2!=null) {
//            Matrix matrix2 = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date2));
//        }

        ResultInfo info = new ResultInfo();

        if (row != null && col != null && Date != null && Date2 != null) {
            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
            Matrix matrix2 = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date2));
            Matrix matrix3 = computeServiceImpl.matrixAdd(matrix, matrix2);
            matrix3.toString();
            info.setFlag(true);
            info.setData(matrix3);
            info.setErrorMsg("计算成功！");;
        } else {
//            返回提示：无法计算，有空值
            info.setFlag(false);
            info.setErrorMsg("无法计算！");
            System.out.println("shibai");
        }
        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }
    public void matrixMultiply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String row = request.getParameter("row");
        System.out.println("row:" + row);
        String col = request.getParameter("col");
        System.out.println("col" + col);
        String Date = request.getParameter("Date");
        String Date2 = request.getParameter("Date2");
        if (row != null && col != null && Date != null && Date2 != null) {

            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
            Matrix matrix2 = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date2));
            Matrix matrix3 = computeServiceImpl.matrixMultiply(matrix, matrix2);
//            return matrix3;
        } else {
//            返回提示：无法计算，有空值


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }
}

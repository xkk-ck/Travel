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
//        System.out.println("row:" + row);
        String col = request.getParameter("col");
//        System.out.println("col" + col);
        String Date = request.getParameter("Date");
//        System.out.println("Date"+Date);
        String Date2 = request.getParameter("Date2");
//        System.out.println("Date2"+Date2);
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

//            计算成功，返回提示信息和结果
            info.setFlag(true);
            info.setData(matrix3);
            info.setErrorMsg("计算成功！");
        } else {
//            返回提示：无法计算，有空值
            info.setFlag(false);
            info.setErrorMsg("无法计算！");
        }
        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }
    public void matrixMultiply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String row = request.getParameter("row");
        System.out.println("row:" + row);
        String col = request.getParameter("col");
        System.out.println("col" + col);
        String Date = request.getParameter("Date");
        String Date2 = request.getParameter("Date2");

        ResultInfo info = new ResultInfo();

        if (row != null && col != null && Date != null && Date2 != null) {
            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
            Matrix matrix2 = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date2));
            Matrix matrix3 = computeServiceImpl.matrixMultiply(matrix, matrix2);

//            计算成功，返回提示信息和结果
            info.setFlag(true);
            info.setData(matrix3);
            info.setErrorMsg("计算成功！");
        } else {
//            返回提示：无法计算，有空值
            info.setFlag(false);
            info.setErrorMsg("无法计算！");
        }

        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

        public void matrixTranspose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String row = request.getParameter("row");
            String col = request.getParameter("col");
            String Date = request.getParameter("Date");

            ResultInfo info = new ResultInfo();

            if (row != null && col != null && Date != null) {
                Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
                Matrix matrix3 = computeServiceImpl.matrixTranspose(matrix);

//            计算成功，返回提示信息和结果
                info.setFlag(true);
                info.setData(matrix3);
                info.setErrorMsg("计算成功！");
            } else {
//            返回提示：无法计算，有空值
                info.setFlag(false);
                info.setErrorMsg("无法计算！");
            }

            //        将info对象序列化
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(),info);

        }

    public void matrixInverse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");
        String col = request.getParameter("col");
        String Date = request.getParameter("Date");

        ResultInfo info = new ResultInfo();

        if (row != null && col != null && Date != null) {
            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));

            if (matrix.getRow() != matrix.getCol()) {
//                返回提示：无法计算，该矩阵没有逆矩阵
                info.setFlag(false);
                info.setErrorMsg("该矩阵没有逆矩阵！");
            } else {
                Matrix matrix3 = computeServiceImpl.matrixInverse(matrix);

//            计算成功，返回提示信息和结果
                info.setFlag(true);
                info.setData(matrix3);
                info.setErrorMsg("计算成功！");
            }
        }

        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }

    public void matrixRank(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");
        String col = request.getParameter("col");
        String Date = request.getParameter("Date");

        ResultInfo info = new ResultInfo();

        if (row != null && col != null && Date != null) {
            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
            Integer rank  = computeServiceImpl.matrixRank(matrix);

//            计算成功，返回提示信息和结果
            info.setFlag(true);
            info.setData(rank);
            info.setErrorMsg("计算成功！");
        } else {
//            返回提示：无法计算，有空值
            info.setFlag(false);
            info.setErrorMsg("无法计算！");
        }

        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }

    public void determinant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");
        String col = request.getParameter("col");
        String Date = request.getParameter("Date");

        ResultInfo info = new ResultInfo();

        if (row != null && col != null && Date != null) {
            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
            Double product  = computeServiceImpl.determinant(matrix);

//            计算成功，返回提示信息和结果
            info.setFlag(true);
            info.setData(product);
            info.setErrorMsg("计算成功！");
        } else {
//            返回提示：无法计算，有空值
            info.setFlag(false);
            info.setErrorMsg("无法计算！");
        }

        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }

    public void equationsSolution(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");
        String col = request.getParameter("col");
        String Date = request.getParameter("Date");

        ResultInfo info = new ResultInfo();

        if (row != null && col != null && Date != null) {
            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
            Matrix matrix2  = computeServiceImpl.equationsSolution(matrix);

//            计算成功，返回提示信息和结果
            info.setFlag(true);
            info.setData(matrix2);
            info.setErrorMsg("计算成功！");
        } else {
//            返回提示：无法计算，有空值
            info.setFlag(false);
            info.setErrorMsg("无法计算！");
        }

        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }

    public void unequationsSolution(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");
        String col = request.getParameter("col");
        String Date = request.getParameter("Date");

        ResultInfo info = new ResultInfo();

        if (row != null && col != null && Date != null) {
            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
            Matrix matrix2  = computeServiceImpl.unequationsSolution(matrix);

//            计算成功，返回提示信息和结果
            info.setFlag(true);
            info.setData(matrix2);
            info.setErrorMsg("计算成功！");
        } else {
//            返回提示：无法计算，有空值
            info.setFlag(false);
            info.setErrorMsg("无法计算！");
        }

        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }

    public void isCorrelate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");
        String col = request.getParameter("col");
        String Date = request.getParameter("Date");
        String Date2 = request.getParameter("Date2");

        ResultInfo info = new ResultInfo();

        if (row != null && col != null && Date != null) {
            Matrix matrix = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date));
            Matrix matrix2 = new Matrix(Integer.parseInt(row), Integer.parseInt(col), ComputeServiceImpl.getArray(row, col, Date2));
            Boolean result  = computeServiceImpl.isCorrelate(matrix);

//            计算成功，返回提示信息和结果
            info.setFlag(true);
            info.setData(result);
            info.setErrorMsg("计算成功！");
        } else {
//            返回提示：无法计算，有空值
            info.setFlag(false);
            info.setErrorMsg("无法计算！");
        }

        //        将info对象序列化
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }
}

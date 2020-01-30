package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Matrix;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.util.ComputeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/computeServlet")
public class ComputeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取用二维数组
        Map<String,String[]> map = request.getParameterMap();
//        2.封装Matrix对象
        System.out.println(map);
        Matrix matrix = new Matrix();
        try {
            BeanUtils.populate(matrix,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //        3.调用计算工具计算
        ComputeUtils  computeUtils = new ComputeUtils();
        Matrix m =computeUtils.inputMatrix(matrix);

        ResultInfo info = new ResultInfo();

//        4.判断用户对象是否为null
        if (m != null){
//            矩阵插入成功
            info.setFlag(true);
            info.setErrorMsg("矩阵插入成功");
        }else{
            //            矩阵插入失败
            info.setFlag(false);
            info.setErrorMsg("矩阵插入失败");
        }

//        响应数据
        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }
}

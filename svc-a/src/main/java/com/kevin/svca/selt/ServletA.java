package com.kevin.svca.selt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author TX
 * @date 2021/11/30 11:55
 */
@WebServlet(name = "TestServlet",
        urlPatterns = { "/HelloServlet" },
        initParams = {
            @WebInitParam(name = "p1", value = "v1")
        })
public class ServletA extends HttpServlet {

    public ServletA(){
        super();
        System.out.println("ServletA 被初始化了");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //控制台打印客户端请求访问时间和请求方式
        System.out.println(System.currentTimeMillis() + "客户端的请求方式为：" + request.getMethod());
        //得到一个可以将数据返回给客户端的打印对象
        PrintWriter out = response.getWriter();
        //可通过out实例的println方法输出到客户端
        //request.getContextPath()可以获得项目的根路径，一般为项目名，可以用作绝对定位
        out.println("Served at: " + request.getContextPath());
        //获取创建Servlet时的初始化参数，可以通过name获取
        String name = this.getInitParameter("p1");
        //将获取的初始化参数输出到前端
        out.println("name: " + name);
    }
}

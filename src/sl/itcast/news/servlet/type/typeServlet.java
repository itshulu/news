package sl.itcast.news.servlet.type;

import sl.itcast.news.entity.type;
import sl.itcast.news.service.impl.typeServiceImpl;
import sl.itcast.news.service.typeService;
import sl.itcast.news.servlet.news.allNewsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "typeServlet", urlPatterns = "/typeServlet")
public class typeServlet extends HttpServlet {
    private typeService typeService=new typeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println(method);
        Class<typeServlet> typeServletletClass = typeServlet.class;
        try {
            Method declaredMethod = typeServletletClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void typeList(HttpServletRequest request,HttpServletResponse response){
        try {
            List<type> list = typeService.selectType();
            request.setAttribute("list",list);
            list.forEach(System.out::println);
            request.getRequestDispatcher("/addNews.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

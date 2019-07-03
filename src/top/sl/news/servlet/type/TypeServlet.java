package top.sl.news.servlet.type;

import top.sl.news.entity.Type;
import top.sl.news.service.impl.TypeServiceImpl;
import top.sl.news.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TypeServlet", urlPatterns = "/TypeServlet")
public class TypeServlet extends HttpServlet {
    private TypeService typeService=new TypeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        Class<TypeServlet> typeServletletClass = TypeServlet.class;
        try {
            Method declaredMethod = typeServletletClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void typeList(HttpServletRequest request,HttpServletResponse response){
        try {
            List<Type> list = typeService.selectType();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/addNews.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

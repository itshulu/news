package sl.itcast.news.servlet.admin;

import sl.itcast.news.entity.admin;
import sl.itcast.news.service.adminService;
import sl.itcast.news.service.impl.adminServiceImpl;
import sl.itcast.news.servlet.news.allNewsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "adminServlet", urlPatterns = "/adminServlet")
public class adminServlet extends HttpServlet {
    private adminService adminService = new adminServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        Class<adminServlet>   adminServletClass=adminServlet.class;
        try {
            Method declaredMethod = adminServletClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void quire(HttpServletRequest request, HttpServletResponse response) {
        String adminname = request.getParameter("adminname");
        String adminpass =request.getParameter("adminpass");
        admin admin = null;
        try {
            admin = adminService.quire(adminname,adminpass);
            if(admin!=null){
                request.getRequestDispatcher("/allNewsServlet?method=allNews").forward(request,response);
            }else{
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void adminQuire(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        String adminpass =request.getParameter("adminpass");
        if(adminname==null||adminpass==null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        admin admin = null;
        try {
            admin = adminService.quire(adminname,adminpass);
            if(admin!=null){
                request.getRequestDispatcher("/allNewsServlet?method=AllNews").forward(request,response);
            }else{
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

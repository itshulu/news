package top.sl.news.servlet.admin;

import top.sl.news.entity.Admin;
import top.sl.news.service.AdminService;
import top.sl.news.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "AdminServlet", urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        Class<AdminServlet>   adminServletClass= AdminServlet.class;
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
        Admin admin = null;
        try {
            admin = adminService.quire(adminname,adminpass);
            if(admin!=null){
                request.getRequestDispatcher("/AllNewsServlet?method=allNews").forward(request,response);
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
        Admin admin = null;
        try {
            admin = adminService.quire(adminname,adminpass);
            if(admin!=null){
                request.getRequestDispatcher("/AllNewsServlet?method=AllNews").forward(request,response);
            }else{
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

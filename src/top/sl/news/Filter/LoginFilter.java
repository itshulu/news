package top.sl.news.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/AdminServlet", "/TypeServlet", "/AllNewsServlet","/LoginOut"})
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String method = request.getParameter("method");
        if ("/LoginOut".equals(request.getServletPath())) {
            session.setAttribute("login", false);
            response.sendRedirect(request.getServletContext().getContextPath() + "/login.jsp");
            return;
        }
        if ("search.jsp".equals(request.getServletPath()) || "/login.jsp".equals(request.getServletPath())
                || "/AdminServlet".equals(request.getServletPath()) || ("allNews".equals(method)) || ("updataLikeNew".equals(method))
                || ("AllNews".equals(method)) || ("findBynewId".equals(method)) || ("delect".equals(method)) || ("typeList".equals(method))
                || ("updata".equals(method)) || ("findById".equals(method)) || ("addNews".equals(method))) {
            chain.doFilter(request, response);
        } else {
            if (session.getAttribute("login") != null) {
                Boolean login = (Boolean) session.getAttribute("login1");
                if (login) {
                    chain.doFilter(request, response);
                } else {
                    response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
                }
            } else {
                session.setAttribute("login", false);
                response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}

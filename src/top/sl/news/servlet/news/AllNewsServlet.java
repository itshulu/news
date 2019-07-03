package top.sl.news.servlet.news;

import top.sl.news.entity.NewsDetail;
import top.sl.news.entity.Type;
import top.sl.news.service.impl.NewsDetailServiceImpl;
import top.sl.news.service.impl.TypeServiceImpl;
import top.sl.news.service.NewsDetailService;
import top.sl.news.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "AllNewsServlet", urlPatterns = "/AllNewsServlet")
public class AllNewsServlet extends HttpServlet {
    private NewsDetailService detailService = new NewsDetailServiceImpl();
    private TypeService service=new TypeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        Class<AllNewsServlet> allNewsServletClass = AllNewsServlet.class;
        try {
            Method declaredMethod = allNewsServletClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void allNews(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<NewsDetail> list = detailService.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/Allnews.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AllNews(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<NewsDetail> list = detailService.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/AllnewsList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findById(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            String id = request.getParameter("id");
            NewsDetail detail = detailService.findById(id);
            request.setAttribute("detail", detail);
            request.getRequestDispatcher("/Newsdetails.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void findBynewId(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            String id = request.getParameter("id");
            NewsDetail detail = detailService.findById(id);
            request.setAttribute("detail", detail);
            System.out.println(detail);
            List<Type> list = service.selectType();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/updata.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updataLikeNew(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            String name = request.getParameter("name");
            List<NewsDetail> list = detailService.updataLikeNew(name);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/Allsearch.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updata(HttpServletRequest request,HttpServletResponse response){
        NewsDetail newsDetail = new NewsDetail();
        newsDetail.setId(request.getParameter("id"));
        newsDetail.setTitle(request.getParameter("title"));
        newsDetail.setContent(request.getParameter("content"));
        newsDetail.setAuthor(request.getParameter("author"));
        newsDetail.setType_id(request.getParameter("type_id"));
        detailService.updataNew(newsDetail);
        try {
            response.sendRedirect("/AllNewsServlet?method=AllNews");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addNews(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        NewsDetail newsDetail = new NewsDetail();
        newsDetail.setId(UUID.randomUUID().toString());
        newsDetail.setTitle(request.getParameter("title"));
        newsDetail.setContent(request.getParameter("content"));
        newsDetail.setAuthor(request.getParameter("author"));
        try {
            newsDetail.setTime(new Date());
            newsDetail.setType_id(request.getParameter("type_id"));
            detailService.addNew(newsDetail);
            request.getRequestDispatcher("/AllNewsServlet?method=AllNews").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void delect(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        detailService.delectNew(id);
        try {
            request.getRequestDispatcher("/AllNewsServlet?method=AllNews").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

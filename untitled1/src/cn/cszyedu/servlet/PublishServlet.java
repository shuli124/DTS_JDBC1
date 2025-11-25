package cn.cszyedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cszy.po.Articles;

public class PublishServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取参数
        String articType = request.getParameter("articType");
        String articTitle = request.getParameter("articTitle");
        String articContent = request.getParameter("articContent");
//        User user = (User) request.getSession().getAttribute("user");
//        String articAuthor = user.getUserName();

        if (articTitle == null || articTitle == "" || articContent == null || articContent == "") {
            request.setAttribute("message", "文章标题和文章内容不能为空");
            request.getRequestDispatcher("/publish.jsp").forward(request, response);
        } else {
            Articles article = new Articles(null, articType, articTitle, articContent, request.getSession().getAttribute("userName").toString(), new Date());
            request.setAttribute("article", article);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/user.jsp");
        }
        //System.out.println(articType);
    }
}
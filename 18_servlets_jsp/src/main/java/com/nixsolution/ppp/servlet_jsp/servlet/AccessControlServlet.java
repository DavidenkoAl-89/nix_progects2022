package com.nixsolution.ppp.servlet_jsp.servlet;

import com.nixsolution.ppp.servlet_jsp.connection.ConnectionManager;
import com.nixsolution.ppp.servlet_jsp.dao.JdbcUserDao;
import com.nixsolution.ppp.servlet_jsp.dao.UserDao;
import com.nixsolution.ppp.servlet_jsp.entity.User;
import com.nixsolution.ppp.servlet_jsp.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.nixsolution.ppp.servlet_jsp.util.SqlCommand.*;

@WebServlet(name = "hello", urlPatterns = "/hello")
public class AccessControlServlet extends HttpServlet {
    ConnectionManager connectionManager = new ConnectionManager(RESOURCES_PATH);
    UserDao userDao = new JdbcUserDao(connectionManager);
    UserService userService = new UserService(userDao);

    @Override
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession();
        httpServletResponse.setContentType("text/html");
        String password = httpServletRequest.getParameter("password");
        User user = userService.findByLogin(httpServletRequest.getParameter("username"));
        RequestDispatcher rd;
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("userInSession", user);
        }
        rd = httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/hello.jsp");
        if (user.getRole().getRoleId() == 1) {
            rd = httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/admin_message_page.jsp");
        }
        rd.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("userInSession", null);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
    }
}
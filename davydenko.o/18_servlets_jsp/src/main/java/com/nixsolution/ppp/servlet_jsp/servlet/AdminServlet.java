package com.nixsolution.ppp.servlet_jsp.servlet;

import com.nixsolution.ppp.servlet_jsp.connection.ConnectionManager;
import com.nixsolution.ppp.servlet_jsp.dao.JdbcRoleDao;
import com.nixsolution.ppp.servlet_jsp.dao.JdbcUserDao;
import com.nixsolution.ppp.servlet_jsp.dao.RoleDao;
import com.nixsolution.ppp.servlet_jsp.dao.UserDao;
import com.nixsolution.ppp.servlet_jsp.entity.Role;
import com.nixsolution.ppp.servlet_jsp.entity.User;
import com.nixsolution.ppp.servlet_jsp.service.RoleService;
import com.nixsolution.ppp.servlet_jsp.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static com.nixsolution.ppp.servlet_jsp.util.SqlCommand.*;

@WebServlet(name = "admin", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(AdminServlet.class);
    ConnectionManager connectionManager = new ConnectionManager(RESOURCES_PATH);
    RoleDao roleDao = new JdbcRoleDao(connectionManager);
    UserDao userDao = new JdbcUserDao(connectionManager);
    UserService userService = new UserService(userDao);
    RoleService roleService = new RoleService(roleDao);

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<User> users = userService.findAll();
        List<Role> roles = roleService.findAll();
        httpServletRequest.setAttribute("users", users);
        httpServletRequest.setAttribute("roles", roles);
        httpServletRequest.getRequestDispatcher("//WEB-INF/jsp/admin_page.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String message;
        User user = new User();

        if (httpServletRequest.getParameter("removeButt") != null) {
            java.lang.Long userId = java.lang.Long.parseLong(httpServletRequest.getParameter("removeButt"));
            user.setId(userId);
            try {
                userService.remove(user);
                message = "User has been removed";
            } catch (SQLException e) {
                LOG.catching(Level.ERROR, e);
                message = "The system could not remove user!";
            }
        } else {
            user.setLogin(httpServletRequest.getParameter("login"));
            user.setPassword(httpServletRequest.getParameter("password"));
            user.setEmail(httpServletRequest.getParameter("email"));
            user.setFirstName(httpServletRequest.getParameter("firstName"));
            user.setLastName(httpServletRequest.getParameter("lastName"));
            user.setBirthday(Date.valueOf(httpServletRequest.getParameter("birthday")));
            user.setRole(roleService.findByName(httpServletRequest.getParameter("role")));

            Long userId = Long.parseLong(httpServletRequest.getParameter("Butt"));
            if (userId != 0) {
                user.setId(userId);
                userService.update(user);
                message = "User has been updated";
            } else {
                userService.create(user);
                message = "User has been created";
            }
        }
        httpServletRequest.setAttribute("message", message);
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/admin_message_page.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.nixsolution.ppp.servlet_jsp.util.SqlCommand.*;

@WebServlet(name = "data", urlPatterns = "/data")
public class UserFormServlet extends HttpServlet {
    RoleDao roleDao = new JdbcRoleDao(new ConnectionManager(RESOURCES_PATH));
    UserDao userDao = new JdbcUserDao(new ConnectionManager(RESOURCES_PATH));
    UserService userService = new UserService(userDao);
    RoleService roleService = new RoleService(roleDao);

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
      Long id = Long.parseLong(httpServletRequest.getParameter("Butt"));
        User user = null;
        List<Role> roles = roleService.findAll();
        if (id != 0) {
                user = userService.findById(id);
            }
        httpServletRequest.setAttribute("user", user);
        httpServletRequest.setAttribute("roles", roles);
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/user_form_page.jsp").forward(httpServletRequest, httpServletResponse);
    }
}

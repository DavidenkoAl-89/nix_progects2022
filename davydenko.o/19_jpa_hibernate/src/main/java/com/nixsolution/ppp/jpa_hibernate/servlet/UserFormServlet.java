package com.nixsolution.ppp.jpa_hibernate.servlet;

import com.nixsolution.ppp.jpa_hibernate.dao.HibernateRoleDao;
import com.nixsolution.ppp.jpa_hibernate.dao.HibernateUserDao;
import com.nixsolution.ppp.jpa_hibernate.entity.Role;
import com.nixsolution.ppp.jpa_hibernate.entity.User;
import com.nixsolution.ppp.jpa_hibernate.service.RoleService;
import com.nixsolution.ppp.jpa_hibernate.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "data", urlPatterns = "/data")
public class UserFormServlet extends HttpServlet {
  HibernateRoleDao hibernateRoleDao = new HibernateRoleDao();
  HibernateUserDao hibernateUserDao = new HibernateUserDao();
    UserService userService = new UserService(hibernateUserDao);
    RoleService roleService = new RoleService(hibernateRoleDao);

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

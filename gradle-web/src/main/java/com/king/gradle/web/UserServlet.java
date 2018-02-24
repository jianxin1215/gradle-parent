package com.king.gradle.web;

import com.king.gradle.api.User;
import com.king.gradle.service.UserService;
import com.king.gradle.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user.htm")
public class UserServlet extends HttpServlet {

    private Logger logger = LogManager.getLogger();

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        logger.debug("requestURI: {}", requestURI);

        List<User> list = userService.list();

        if (list != null && list.size() > 0) {
            resp.getWriter().write(list.size());
        } else {
            resp.getWriter().write("no users data");
        }
    }
}

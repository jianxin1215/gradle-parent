package com.king.gradle.web;

import com.king.gradle.api.User;
import com.king.gradle.service.UserService;
import com.king.gradle.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = userService.list();

        if (list != null && list.size() > 0) {
            resp.getWriter().write(list.size());
        }
    }
}

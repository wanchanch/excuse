package com.controller;

import com.dao.UserDao;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sname = req.getParameter("sname");
        String sclass = req.getParameter("sclass");
        String sex = req.getParameter("sex");
        String role= req.getParameter("role");
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setPassword(password);
        user.setSname(sname);
        user.setSclass(sclass);
        user.setSex(sex);
        UserDao userDao = new UserDao();

        if ("学生".equals(role)) {
            try {
                if (userDao.register(user)>0) {
                    req.setAttribute("user", user);
                    req.getRequestDispatcher("Login.jsp").forward(req, resp);
                } else {
                    resp.setContentType("text/html; charset=utf-8");
                    try (PrintWriter printWriter = resp.getWriter()) {
                        printWriter.println("登录失败，请检查您的用户名和密码。");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else if ("老师".equals(role)){
            try {
                if (userDao.teacherRegister(user)>0) {
                    req.setAttribute("user", user);
                    req.getRequestDispatcher("Login.jsp").forward(req, resp);
                } else {
                    resp.setContentType("text/html; charset=utf-8");
                    try (PrintWriter printWriter = resp.getWriter()) {
                        printWriter.println("登录失败，请检查您的用户名和密码。");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

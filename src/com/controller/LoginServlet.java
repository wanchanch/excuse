package com.controller;

import com.dao.UserDao;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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

        String sex = req.getParameter("sex");
        String role = req.getParameter("role");

        HttpSession session = req.getSession();
        session.setAttribute("role", role);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSname(sname);

        user.setSex(sex);
        UserDao userDao = new UserDao();

        if ("学生".equals(role)) {
            boolean flag = userDao.login(user.getUsername(), user.getPassword());

            if (flag) {

                session.setAttribute("username", username);
                try {
                    String sclass=UserDao.getStudent_class(username);
                    String name=UserDao.getStudent_name(username);
                    session.setAttribute("sclass", sclass);
                    session.setAttribute("name", name);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                req.getRequestDispatcher("list").forward(req, resp);

            } else {
                resp.setContentType("text/html; charset=utf-8");
                try (PrintWriter printWriter = resp.getWriter()) {
                    printWriter.println("登录失败，请检查您的用户名和密码。");
            }
            }
        }else if ("老师".equals(role)) {
            boolean flag = userDao.teacherLogin(user.getUsername(), user.getPassword());

            if (flag) {
                session.setAttribute("username", username);
                try {
                    String sclass=UserDao.getTeacher_class(username);
                    session.setAttribute("sclass", sclass);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                req.getRequestDispatcher("tlist").forward(req, resp);
            } else {
                resp.setContentType("text/html; charset=utf-8");
                try (PrintWriter printWriter = resp.getWriter()) {
                    printWriter.println("登录失败，请检查您的用户名和密码。");
                }
            }
        }else if ("管理员".equals(role)) {
            boolean flag = userDao.adminLogin(user.getUsername(), user.getPassword());

            if (flag) {
                session.setAttribute("username", username);
                req.setAttribute("user", user);
                req.getRequestDispatcher("adminList").forward(req, resp);
            } else {
                resp.setContentType("text/html; charset=utf-8");
                try (PrintWriter printWriter = resp.getWriter()) {
                    printWriter.println("登录失败，请检查您的用户名和密码。");
                }
            }
        }
    }
}

package com.controller;

import com.dao.UserDao;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete_student")
public class Delete_StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        User user = new User();
        user.setUsername(username);

        UserDao userDao = new UserDao();
        try {
            userDao.deleteStudent(user);
            resp.getWriter().write("删除成功");
        } catch (SQLException e) {
            resp.getWriter().write("删除失败 " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

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
import java.util.List;
@WebServlet("/teacher_list")
public class User_teacherListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<User> userlist;
        try {
            userlist= UserDao.getUser_teacher();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("teacher_list", userlist);
        req.getRequestDispatcher("/User_TeacherList.jsp").forward(req, resp);
    }
}

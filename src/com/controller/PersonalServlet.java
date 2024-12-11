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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/personal_list")
public class PersonalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");
        UserDao userDao = new UserDao();
        User user;
        if (role.equals("学生")) {
            try {
                user = userDao.getStudentByUsername(username);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/PersonalStudent.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new ServletException("Failed to get user data", e);
            }
        } else if (role.equals("老师")) {
            try {
                user = userDao.getTeacherByUsername(username);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/PersonalStudent.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new ServletException("Failed to get user data", e);
            }
        }
    }
}